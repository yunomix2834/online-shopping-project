package com.business.dto.response;

import com.business.constant.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDto {
    String id;
    String name;
    String slug;
    String description;
    ProductStatus status;
    String brandId;
}