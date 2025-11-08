package com.business.service;

import com.business.constant.ProductStatus;
import com.business.dto.request.ProductCreateRequestDto;
import com.business.dto.request.ProductUpdateRequestDto;
import com.business.dto.response.ProductResponseDto;
import org.common.http.Envelope;

public interface IProductService {
    void create(ProductCreateRequestDto productCreateRequestDto);

    void update(
            String id,
            ProductUpdateRequestDto productUpdateRequestDto
    );

    void softDelete(String id);

    void restore(String id);

    void publish(String id);

    void unpublish(String id);

    void archive(String id);

    ProductResponseDto getById(String id);

    ProductResponseDto getBySlug(String slug);

    Envelope.Page<ProductResponseDto> list(
            String q,
            String brandId,
            String categoryId,
            ProductStatus status,
            int page, int size);

    void assignCategory(String productId, String categoryId);

    void unassignCategory(String productId, String categoryId);
}