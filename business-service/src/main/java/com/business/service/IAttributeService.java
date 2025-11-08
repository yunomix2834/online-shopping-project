package com.business.service;

import com.business.dto.request.AttributeCreateRequestDto;
import com.business.dto.response.AttributeResponseDto;
import org.common.http.Envelope;

public interface IAttributeService {
  void create(AttributeCreateRequestDto dto);
  void softDelete(String id);
  void restore(String id);
  Envelope.Page<AttributeResponseDto> list(
      String q,
      int page, int size);

  void assignToVariant(
      String variantId,
      String attributeId);
  void unassignFromVariant(
      String variantId,
      String attributeId);
  Envelope.Page<AttributeResponseDto> listByVariant(
      String variantId,
      int page, int size);
}
