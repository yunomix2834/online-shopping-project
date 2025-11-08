package com.business.mapper;

import com.business.dto.request.CategoryCreateRequestDto;
import com.business.dto.request.CategoryUpdateRequestDto;
import com.business.dto.response.CategoryResponseDto;
import com.business.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryMapper {
    Category toCategoryFromCategoryCreateRequestDto(
            CategoryCreateRequestDto categoryCreateRequestDto);
    void patchCategoryFromCategoryUpdateRequestDto(
            @MappingTarget Category category,
            CategoryUpdateRequestDto categoryUpdateRequestDto
    );
    CategoryResponseDto toCategoryResponseDtoFromCategory(
            Category category);
}