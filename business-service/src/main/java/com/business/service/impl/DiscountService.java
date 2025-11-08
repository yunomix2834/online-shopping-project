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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DiscountService implements IDiscountService {
  DiscountsRepository repo;
  DiscountMapper mapper;

  @Override
  public void create(DiscountCreateRequestDto dto) {
    AuthenticationHelper.requireAdmin();
    repo.save(mapper.toDiscountFromDiscountCreateRequestDto(dto));
  }

  @Override public void update(
      String id,
      DiscountUpdateRequestDto dto) {
    AuthenticationHelper.requireAdmin();
    Discount d = repo.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.DISCOUNT_NOT_FOUND));
    mapper.patchDiscountFromDiscountUpdateRequestDto(d, dto);
    repo.save(d);
  }

  @Override public void softDelete(String id) {
    AuthenticationHelper.requireAdmin();
    Discount d = repo.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.IMAGE_NOT_FOUND));
    d.markDeleted(AuthenticationHelper.getMyUserId());
    repo.save(d);
  }

  @Override public void restore(String id) {
    AuthenticationHelper.requireAdmin();
    if (repo.nativeRestore(id)==0) {
      throw new AppException(ErrorCode.IMAGE_NOT_FOUND);
    }
  }
  @Override
  public void toggleActive(
      String id,
      boolean active) {
    AuthenticationHelper.requireAdmin();
    Discount d = repo.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.IMAGE_NOT_FOUND));
    d.setActive(active);
    repo.save(d);
  }
  @Override
  public DiscountResponseDto getByCode(String code) {
    Discount d = repo.findByCode(code)
        .orElseThrow(() -> new AppException(ErrorCode.IMAGE_NOT_FOUND));
    return mapper.toDiscountResponseDtoFromDiscount(d);
  }
  @Override public DiscountValidation validateAndAmount(
      String code, BigDecimal orderValue, Instant at) {
    Discount d = repo.findByCode(code).orElse(null);
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
    Page<Discount> p = repo.listEffective(only, at, PageRequest.of(page, size));
    List<DiscountResponseDto> docs = p.getContent()
        .stream()
        .map(mapper::toDiscountResponseDtoFromDiscount)
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
