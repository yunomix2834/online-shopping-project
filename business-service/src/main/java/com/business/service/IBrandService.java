package com.business.service;

import com.business.dto.request.BrandCreateRequestDto;
import com.business.dto.request.BrandUpdateRequestDto;
import com.business.dto.response.BrandResponseDto;
import org.common.http.Envelope;

public interface IBrandService {
    void create(BrandCreateRequestDto brandCreateRequestDto);

    void update(String id, BrandUpdateRequestDto brandUpdateRequestDto);

    void softDelete(String id);

    void restore(String id);

    BrandResponseDto getById(String id);

    BrandResponseDto getBySlug(String slug);

    Envelope.Page<BrandResponseDto> list(
            String q,
            int page, int size
    );
}