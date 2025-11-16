package com.business.service.impl;

import com.business.dto.request.VariantCreateRequestDto;
import com.business.dto.request.VariantUpdateRequestDto;
import com.business.dto.response.VariantResponseDto;
import com.business.entity.Product;
import com.business.entity.ProductVariant;
import com.business.helper.AuthenticationHelper;
import com.business.mapper.VariantMapper;
import com.business.repository.ProductVariantsRepository;
import com.business.repository.ProductsRepository;
import com.business.service.IVariantService;
import java.math.BigDecimal;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.common.exception.AppException;
import org.common.exception.ErrorCode;
import org.common.http.Envelope;
import org.common.security.RequireAdmin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class VariantService implements IVariantService {
  ProductVariantsRepository productVariantsRepository;
  ProductsRepository productsRepository;
  VariantMapper variantMapper;

  @Override
  @RequireAdmin
  public void create(VariantCreateRequestDto dto) {
    if (productVariantsRepository.findBySku(dto.getSku()).isPresent())
      throw new AppException(ErrorCode.RESOURCE_ALREADY_EXISTS);
    Product p = productsRepository.findById(dto.getProductId())
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    ProductVariant v = variantMapper.toVariantFromVariantCreateRequestDto(dto);
    v.setProduct(p);
    productVariantsRepository.save(v);
  }

  @Override
  @RequireAdmin
  public void update(String id, VariantUpdateRequestDto dto) {
    ProductVariant v = productVariantsRepository.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    if (dto.getSku()!=null && !dto.getSku().isBlank()) {
      productVariantsRepository.findBySku(dto.getSku())
          .filter(x -> !x.getId().equals(id))
          .ifPresent(x -> { throw new AppException(ErrorCode.RESOURCE_ALREADY_EXISTS); });
    }
    variantMapper.patchVariantFromVariantUpdateRequestDto(v, dto);
    productVariantsRepository.save(v);
  }

  @Override
  @RequireAdmin
  public void softDelete(String id) {
    ProductVariant v = productVariantsRepository.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    v.markDeleted(AuthenticationHelper.getMyUserId());
    productVariantsRepository.save(v);
  }

  @Override
  @RequireAdmin
  public void restore(String id) {
    if (productVariantsRepository.nativeRestore(id)==0)
      throw new AppException(ErrorCode.RESOURCE_NOT_FOUND);
  }

  @Override
  public VariantResponseDto findBySku(String sku) {
    ProductVariant v = productVariantsRepository.findBySku(sku)
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    return variantMapper.toVariantResponseDtoFromVariant(v);
  }

  @Override
  @RequireAdmin
  public void patchPrice(
      String id,
      BigDecimal price,
      BigDecimal originalPrice) {
    ProductVariant v = productVariantsRepository.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    if (price!=null) v.setPrice(price);
    if (originalPrice!=null) v.setOriginalPrice(originalPrice);
    productVariantsRepository.save(v);
  }

  @Override
  public Envelope.Page<VariantResponseDto> listByProduct(
      String productId,
      int page, int size) {
    Page<ProductVariant> p = productVariantsRepository
        .listByProduct(productId, PageRequest.of(page, size));
    List<VariantResponseDto> docs = p.getContent().stream()
        .map(variantMapper::toVariantResponseDtoFromVariant).toList();
    return Envelope.okPage(
        p.getNumber(),
        p.getSize(),
        p.getTotalElements(),
        p.getTotalPages(),
        docs
    ).getData();
  }
}
