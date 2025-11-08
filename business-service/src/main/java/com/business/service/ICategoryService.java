package com.business.service;

import com.business.dto.model.CategoryTreeNode;
import com.business.dto.request.CategoryCreateRequestDto;
import com.business.dto.request.CategoryUpdateRequestDto;
import com.business.dto.response.CategoryResponseDto;
import org.common.http.Envelope;

public interface ICategoryService {
    void create(CategoryCreateRequestDto categoryCreateRequestDto);

    void update(
            String id,
            CategoryUpdateRequestDto categoryUpdateRequestDto
    );

    void softDelete(String id);

    void restore(String id);

    void reparent(String id, String newParentId);

    CategoryResponseDto getById(String id);

    CategoryResponseDto getBySlug(String slug);

    Envelope.Page<CategoryResponseDto> list(
            String q,
            int page, int size
    );

    // tree/children
    CategoryTreeNode tree();

    Envelope.Page<CategoryResponseDto> children(
            String id,
            int page, int size
    );
}