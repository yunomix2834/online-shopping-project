package com.business.service.impl;

import com.business.dto.request.AttributeCreateRequestDto;
import com.business.dto.response.AttributeResponseDto;
import com.business.entity.Attribute;
import com.business.entity.ProductVariant;
import com.business.entity.VariantAttributeValue;
import com.business.helper.AuthenticationHelper;
import com.business.mapper.AttributeMapper;
import com.business.repository.AttributesRepository;
import com.business.repository.ProductVariantsRepository;
import com.business.repository.VariantAttributeValuesRepository;
import com.business.service.IAttributeService;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.common.exception.AppException;
import org.common.exception.ErrorCode;
import org.common.http.Envelope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AttributeService implements IAttributeService {
  AttributesRepository attributesRepository;
  ProductVariantsRepository productVariantsRepository;
  VariantAttributeValuesRepository variantAttributeValuesRepository;
  AttributeMapper attributeMapper;

  @Override
  public void create(
      AttributeCreateRequestDto dto) {
    AuthenticationHelper.requireAdmin();
    attributesRepository.save(attributeMapper
        .toAttributeFromAttributeCreateRequestDto(dto));
  }

  @Override
  public void softDelete(String id) {
    AuthenticationHelper.requireAdmin();
    Attribute a = attributesRepository.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.ATTRIBUTE_NOT_FOUND));
    a.markDeleted(AuthenticationHelper.getMyUserId());
    attributesRepository.save(a);
  }

  @Override
  public void restore(String id) {
    AuthenticationHelper.requireAdmin();
    if (attributesRepository.nativeRestore(id) == 0) {
      throw new AppException(ErrorCode.ATTRIBUTE_NOT_FOUND);
    }
  }

  @Override
  public Envelope.Page<AttributeResponseDto> list(
      String q,
      int page,
      int size) {
    Page<Attribute> p = attributesRepository.search(q,
        PageRequest.of(page,
            size));
    List<AttributeResponseDto>
        docs = p.getContent()
        .stream()
        .map(attributeMapper::toAttributeResponseDtoFromAttribute)
        .toList();
    return Envelope.okPage(
        p.getNumber(),
        p.getSize(),
        p.getTotalElements(),
        p.getTotalPages(),
        docs).getData();
  }

  @Override
  public void assignToVariant(
      String variantId, String attributeId) {
    AuthenticationHelper.requireAdmin();
    productVariantsRepository.findById(variantId)
        .orElseThrow(() -> new AppException(ErrorCode.VARIANT_NOT_FOUND));
    attributesRepository.findById(attributeId)
        .orElseThrow(() -> new AppException(ErrorCode.ATTRIBUTE_NOT_FOUND));
    if (variantAttributeValuesRepository.existsLink(variantId, attributeId)) return;
    VariantAttributeValue vav = VariantAttributeValue.builder()
        .variant(ProductVariant.builder().id(variantId).build())
        .attribute(Attribute.builder().id(attributeId).build())
        .build();
    variantAttributeValuesRepository.save(vav);
  }
  @Override public void unassignFromVariant(
      String variantId, String attributeId) {
    AuthenticationHelper.requireAdmin();
    variantAttributeValuesRepository.deleteLink(variantId, attributeId);
  }
  @Override public Envelope.Page<AttributeResponseDto> listByVariant(
      String variantId, int page, int size) {
    Page<Attribute> p = variantAttributeValuesRepository.listAttributes(
        variantId, PageRequest.of(page, size));
    List<AttributeResponseDto> docs = p.getContent()
        .stream()
        .map(attributeMapper::toAttributeResponseDtoFromAttribute)
        .toList();
    return Envelope.okPage(
        p.getNumber(),
        p.getSize(),
        p.getTotalElements(),
        p.getTotalPages(),
        docs
    ).getData();
  }
}
