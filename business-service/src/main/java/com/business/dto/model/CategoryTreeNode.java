package com.business.dto.model;

import com.business.dto.response.CategoryResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryTreeNode {
    CategoryResponseDto data;
    List<CategoryTreeNode> children;
}