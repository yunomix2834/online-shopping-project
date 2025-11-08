package com.business.service;

import com.business.dto.request.VariantCreateRequestDto;
import com.business.dto.request.VariantUpdateRequestDto;
import com.business.dto.response.VariantResponseDto;
import java.math.BigDecimal;
import org.common.http.Envelope;

public interface IVariantService {
  void create(VariantCreateRequestDto dto);
  void update(String id, VariantUpdateRequestDto dto);
  void softDelete(String id);
  void restore(String id);
  VariantResponseDto findBySku(String sku);
  void patchPrice(String id, BigDecimal price, BigDecimal originalPrice);
  Envelope.Page<VariantResponseDto> listByProduct(String productId, int page, int size);
}
