package com.business.service.impl;

import com.business.dto.model.DiscountValidation;
import com.business.dto.request.DiscountCreateRequestDto;
import com.business.dto.request.DiscountUpdateRequestDto;
import com.business.dto.response.DiscountResponseDto;
import com.business.entity.Discount;
import com.business.helper.AuthenticationHelper;
import com.business.mapper.DiscountMapper;
import com.business.repository.DiscountsRepository;
import com.business.service.IDiscountService;
import java.math.BigDecimal;
import java.time.Instant;
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
public class DiscountService implements IDiscountService {
  DiscountsRepository discountsRepository;
  DiscountMapper discountMapper;

  @Override
  @RequireAdmin
  public void create(DiscountCreateRequestDto dto) {
    discountsRepository.save(discountMapper.toDiscountFromDiscountCreateRequestDto(dto));
  }

  @Override
  @RequireAdmin
  public void update(
      String id,
      DiscountUpdateRequestDto dto) {
    Discount d = discountsRepository.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    discountMapper.patchDiscountFromDiscountUpdateRequestDto(d, dto);
    discountsRepository.save(d);
  }

  @Override
  @RequireAdmin
  public void softDelete(String id) {
    Discount d = discountsRepository.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    d.markDeleted(AuthenticationHelper.getMyUserId());
    discountsRepository.save(d);
  }

  @Override
  @RequireAdmin
  public void restore(String id) {
    if (discountsRepository.nativeRestore(id)==0) {
      throw new AppException(ErrorCode.RESOURCE_NOT_FOUND);
    }
  }
  @Override
  @RequireAdmin
  public void toggleActive(
      String id,
      boolean active) {
    Discount d = discountsRepository.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    d.setActive(active);
    discountsRepository.save(d);
  }
  @Override
  public DiscountResponseDto getByCode(String code) {
    Discount d = discountsRepository.findByCode(code)
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    return discountMapper.toDiscountResponseDtoFromDiscount(d);
  }
  @Override public DiscountValidation validateAndAmount(
      String code, BigDecimal orderValue, Instant at) {
    Discount d = discountsRepository.findByCode(code).orElse(null);
    if (d == null) {
      return DiscountValidation.builder()
          .valid(false)
          .reason("NOT_FOUND")
          .amount(BigDecimal.ZERO)
          .build();
    }

    if (Boolean.FALSE.equals(d.getActive())) {
      return DiscountValidation.builder()
          .valid(false)
          .reason("INACTIVE")
          .amount(BigDecimal.ZERO)
          .build();
    }

    if (d.getStartDate() != null && at.isBefore(d.getStartDate())) {
      return DiscountValidation.builder()
          .valid(false)
          .reason("NOT_STARTED")
          .amount(BigDecimal.ZERO)
          .build();
    }

    if (d.getEndDate() != null && at.isAfter(d.getEndDate())) {
      return DiscountValidation.builder()
          .valid(false)
          .reason("EXPIRED")
          .amount(BigDecimal.ZERO)
          .build();
    }
    if (d.getMinOrderValue() != null && orderValue.compareTo(d.getMinOrderValue()) < 0) {
      return DiscountValidation.builder()
          .valid(false)
          .reason("MIN_ORDER_NOT_MET")
          .amount(BigDecimal.ZERO)
          .build();
    }

    BigDecimal amt = switch (d.getType()) {
      case percentage     -> orderValue.multiply(d.getValue()).movePointLeft(2);
      case fixed_amount   -> d.getValue();
    };
    if (amt.signum() < 0) {
      amt = BigDecimal.ZERO;
    }
    if (amt.compareTo(orderValue) > 0) {
      amt = orderValue;
    }
    return DiscountValidation.builder()
        .valid(true)
        .reason("OK")
        .amount(amt)
        .build();
  }
  @Override public Envelope.Page<DiscountResponseDto> list(
      boolean only,
      Instant at, int page, int size) {
    Page<Discount> p = discountsRepository.listEffective(only, at, PageRequest.of(page, size));
    List<DiscountResponseDto> docs = p.getContent()
        .stream()
        .map(discountMapper::toDiscountResponseDtoFromDiscount)
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
