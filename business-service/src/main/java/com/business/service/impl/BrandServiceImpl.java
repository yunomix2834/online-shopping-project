package com.business.service.impl;

import com.business.dto.request.BrandCreateRequestDto;
import com.business.dto.request.BrandUpdateRequestDto;
import com.business.dto.response.BrandResponseDto;
import com.business.entity.Brand;
import com.business.helper.AuthenticationHelper;
import com.business.mapper.BrandMapper;
import com.business.repository.BrandsRepository;
import com.business.service.IBrandService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.common.exception.AppException;
import org.common.exception.ErrorCode;
import org.common.http.Envelope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BrandServiceImpl implements IBrandService {

    BrandsRepository brandsRepository;
    BrandMapper brandMapper;

    @Override @Transactional
    public void create(BrandCreateRequestDto brandCreateRequestDto) {
        Brand b = brandMapper.toBrandFromBrandCreateRequestDto(
                brandCreateRequestDto);
        brandsRepository.save(b);
    }

    @Override @Transactional
    public void update(
            String id,
            BrandUpdateRequestDto brandUpdateRequestDto) {
        Brand b = brandsRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.BRAND_NOT_FOUND));
        brandMapper.patchBrandFromBrandUpdateRequestDto(b, brandUpdateRequestDto);
        brandsRepository.save(b);
    }

    @Override
    @Transactional
    public void softDelete(String id) {
        Brand b = brandsRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.BRAND_NOT_FOUND));
        b.markDeleted(AuthenticationHelper.getMyUserId());
        brandsRepository.save(b);
    }

    @Override
    @Transactional
    public void restore(String id) {
        brandsRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.BRAND_NOT_FOUND));
        int n = brandsRepository.nativeRestore(id);
        if (n == 0) {
            throw new AppException(ErrorCode.BRAND_NOT_FOUND);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public BrandResponseDto getById(String id) {
        return brandsRepository.findById(id)
                .map(brandMapper::toBrandResponseDtoFromBrand)
                .orElseThrow(() -> new AppException(ErrorCode.BRAND_NOT_FOUND));
    }

    @Override
    @Transactional(readOnly = true)
    public BrandResponseDto getBySlug(String slug) {
        return brandsRepository.findBySlug(slug)
                .map(brandMapper::toBrandResponseDtoFromBrand)
                .orElseThrow(() -> new AppException(ErrorCode.BRAND_NOT_FOUND));
    }

    @Override @Transactional(readOnly = true)
    public Envelope.Page<BrandResponseDto> list(
            String q,
            int page, int size) {
        Page<Brand> p = brandsRepository.search(q, PageRequest.of(page, size));
        return Envelope.Page.<BrandResponseDto>builder()
                .page(page)
                .size(size)
                .total(p.getTotalElements())
                .totalPages(Math.max(1, p.getTotalPages()))
                .docs(p.map(brandMapper::toBrandResponseDtoFromBrand).getContent())
                .build();
    }
}