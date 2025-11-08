package com.business.service.impl;

import com.business.dto.request.CategoryCreateRequestDto;
import com.business.dto.request.CategoryUpdateRequestDto;
import com.business.dto.response.CategoryResponseDto;
import com.business.entity.Category;
import com.business.helper.AuthenticationHelper;
import com.business.mapper.CategoryMapper;
import com.business.repository.CategoriesRepository;
import com.business.service.ICategoryService;
import com.business.dto.model.CategoryTreeNode;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.common.exception.AppException;
import org.common.exception.ErrorCode;
import org.common.http.Envelope;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryServiceImpl implements ICategoryService {

    CategoriesRepository categoriesRepository;
    CategoryMapper categoryMapper;

    @Override
    @Transactional
    public void create(CategoryCreateRequestDto categoryCreateRequestDto) {
        Category c = categoryMapper.toCategoryFromCategoryCreateRequestDto(
                categoryCreateRequestDto);
        if (categoryCreateRequestDto.getParentId() != null
                && !categoryCreateRequestDto.getParentId().isBlank()) {
            categoriesRepository.findById(categoryCreateRequestDto.getParentId())
                    .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND));
            c.getParent().setId(categoryCreateRequestDto.getParentId());
        } else {
            c.getParent().setId(null);
        }
        categoriesRepository.save(c);
    }

    @Override
    @Transactional
    public void update(
            String id,
            CategoryUpdateRequestDto categoryUpdateRequestDto) {
        Category c = categoriesRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND));
        categoryMapper.patchCategoryFromCategoryUpdateRequestDto(c,
                categoryUpdateRequestDto);
        categoriesRepository.save(c);
    }

    @Override
    @Transactional
    public void softDelete(String id) {
        Category c = categoriesRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND));
        c.markDeleted(AuthenticationHelper.getMyUserId());
        categoriesRepository.save(c);
    }

    @Override
    @Transactional
    public void restore(String id) {
        categoriesRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND));
        int n = categoriesRepository.nativeRestore(id);
        if (n == 0) {
            throw new AppException(ErrorCode.CATEGORY_NOT_FOUND);
        }
    }

    @Override
    @Transactional
    public void reparent(String id, String newParentId) {
        Category c = categoriesRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND));
        if (newParentId == null || newParentId.isBlank()) {
            c.getParent().setId(null);
        } else {
            categoriesRepository.findById(newParentId)
                    .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND));
            c.getParent().setId(newParentId);
        }
        categoriesRepository.save(c);
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryResponseDto getById(String id) {
        return categoriesRepository.findById(id)
                .map(categoryMapper::toCategoryResponseDtoFromCategory)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND));
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryResponseDto getBySlug(String slug) {
        return categoriesRepository.findBySlug(slug)
                .map(categoryMapper::toCategoryResponseDtoFromCategory)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_FOUND));
    }

    @Override
    @Transactional(readOnly = true)
    public Envelope.Page<CategoryResponseDto> list(
            String q,
            int page, int size) {
        Page<Category> p = categoriesRepository.search(q, PageRequest.of(page, size));
        return Envelope.Page.<CategoryResponseDto>builder()
                .page(page)
                .size(size)
                .total(p.getTotalElements())
                .totalPages(Math.max(1, p.getTotalPages()))
                .docs(p.map(categoryMapper::toCategoryResponseDtoFromCategory).getContent())
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public CategoryTreeNode tree() {
        List<Category> all = categoriesRepository.findAll(Sort.by("name")
                .ascending());
        Map<String, List<Category>> byParent = all.stream()
                .collect(Collectors.groupingBy(c -> Optional.ofNullable(c.getParent().getId())
                        .orElse("ROOT")));

        return CategoryTreeNode.builder()
                .data(null)
                .children(buildChildren("ROOT", byParent))
                .build();
    }

    private List<CategoryTreeNode> buildChildren(
            String parentKey,
            Map<String,List<Category>> byParent){
        return byParent.getOrDefault(parentKey, List.of())
                .stream()
                .map(c -> CategoryTreeNode.builder()
                        .data(categoryMapper.toCategoryResponseDtoFromCategory(c))
                        .children(buildChildren(c.getId(), byParent))
                        .build())
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Envelope.Page<CategoryResponseDto> children(
            String id,
            int page, int size) {
        String parent = (id == null || id.isBlank())
                ? null
                : id;
        List<CategoryResponseDto> docs = categoriesRepository
                .findByParentIdOrderByNameAsc(parent)
                .stream()
                .map(categoryMapper::toCategoryResponseDtoFromCategory)
                .toList();
        int total = docs.size();
        int from = Math.min(page*size, total);
        int to = Math.min(from+size, total);
        return Envelope.Page.<CategoryResponseDto>builder()
                .page(page)
                .size(size)
                .total(total)
                .totalPages((int)Math.max(1, Math.ceil(total/(double)size)))
                .docs(docs.subList(from, to))
                .build();
    }
}