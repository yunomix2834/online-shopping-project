package com.business.service.impl;

import com.business.constant.ProductStatus;
import com.business.dto.request.ProductCreateRequestDto;
import com.business.dto.request.ProductUpdateRequestDto;
import com.business.dto.response.ProductResponseDto;
import com.business.entity.*;
import com.business.helper.AuthenticationHelper;
import com.business.mapper.ProductMapper;
import com.business.repository.*;
import com.business.service.IProductService;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.common.exception.AppException;
import org.common.exception.ErrorCode;
import org.common.http.Envelope;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements IProductService {

    ProductsRepository productsRepository;
    BrandsRepository brandsRepository;
    CategoriesRepository categoriesRepository;
    ProductCategoriesRepository productCategoriesRepository;
    ProductMapper productMapper;

    @Override
    @Transactional
    public void create(ProductCreateRequestDto productCreateRequestDto) {
        Product p = productMapper.toProductFromProductCreateRequestDto(
                productCreateRequestDto);
        if (productCreateRequestDto.getBrandId() != null
                && !productCreateRequestDto.getBrandId().isBlank()) {
            Brand b = brandsRepository.findById(productCreateRequestDto.getBrandId())
                    .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
            p.setBrand(b);
        } else p.setBrand(null);
        p.setStatus(ProductStatus.DRAFT);
        productsRepository.save(p);
    }

    @Override
    @Transactional
    public void update(
            String id,
            ProductUpdateRequestDto productUpdateRequestDto) {
        Product p = productsRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        productMapper.patchProductFromProductUpdateRequestDto(p,
                productUpdateRequestDto);
        if (productUpdateRequestDto.getBrandId()!=null) {
            if (productUpdateRequestDto.getBrandId().isBlank()) {
                p.setBrand(null);
            } else {
                Brand b = brandsRepository.findById(productUpdateRequestDto.getBrandId())
                        .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
                p.setBrand(b);
            }
        }
        productsRepository.save(p);
    }

    @Override
    @Transactional
    public void softDelete(String id) {
        Product p = productsRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        p.markDeleted(AuthenticationHelper.getMyUserId());
        productsRepository.save(p);
    }

    @Override
    @Transactional
    public void restore(String id) {
        productsRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        int n = productsRepository.nativeRestore(id);
        if (n == 0) {
            throw new AppException(ErrorCode.PRODUCT_NOT_FOUND);
        }
    }

    @Override
    @Transactional
    public void publish(String id) {
        Product p = productsRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        p.setStatus(ProductStatus.PUBLISHED);
        productsRepository.save(p);
    }

    @Override
    @Transactional
    public void unpublish(String id) {
        Product p = productsRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        p.setStatus(ProductStatus.UNPUBLISHED);
        productsRepository.save(p);
    }

    @Override
    @Transactional
    public void archive(String id) {
        Product p = productsRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        p.setStatus(ProductStatus.ARCHIVED);
        productsRepository.save(p);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponseDto getById(String id) {
        return productsRepository.findById(id)
                .map(productMapper::toProductResponseDtoFromProduct)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponseDto getBySlug(String slug) {
        return productsRepository.findBySlug(slug)
                .map(productMapper::toProductResponseDtoFromProduct)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
    }

    @Override
    @Transactional(readOnly = true)
    public Envelope.Page<ProductResponseDto> list(
            String q,
            String brandId, String categoryId,
            ProductStatus status, int page, int size) {
        Page<Product> p = productsRepository.filter(
                q,
                brandId,
                categoryId,
                status,
                PageRequest.of(page, size)
        );
        return Envelope.Page.<ProductResponseDto>builder()
                .page(page)
                .size(size)
                .total(p.getTotalElements())
                .totalPages(Math.max(1, p.getTotalPages()))
                .docs(p.map(productMapper::toProductResponseDtoFromProduct).getContent())
                .build();
    }

    @Override
    @Transactional
    public void assignCategory(String productId, String categoryId) {
        Product p = productsRepository.findById(productId)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        Category c = categoriesRepository.findById(categoryId)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));

        if (!productCategoriesRepository.existsLink(productId, categoryId)) {
            ProductCategory link = new ProductCategory();
            link.setProduct(p);
            link.setCategory(c);
            productCategoriesRepository.save(link);
        }
    }

    @Override
    @Transactional
    public void unassignCategory(String productId, String categoryId) {
        productsRepository.findById(productId)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        categoriesRepository.findById(categoryId)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));
        productCategoriesRepository.deleteLink(productId, categoryId);
    }
}