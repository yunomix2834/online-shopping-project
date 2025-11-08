package com.business.service;

import com.business.dto.model.DiscountValidation;
import com.business.dto.request.DiscountCreateRequestDto;
import com.business.dto.request.DiscountUpdateRequestDto;
import com.business.dto.response.DiscountResponseDto;
import java.math.BigDecimal;
import java.time.Instant;
import org.common.http.Envelope;

public interface IDiscountService {
  void create(DiscountCreateRequestDto dto);
  void update(String id, DiscountUpdateRequestDto dto);
  void softDelete(String id);
  void restore(String id);
  void toggleActive(String id, boolean active);

  DiscountResponseDto getByCode(String code);
  DiscountValidation validateAndAmount(
      String code,
      BigDecimal orderValue,
      Instant at
  );
  Envelope.Page<DiscountResponseDto> list(
      boolean onlyEffective,
      Instant at,
      int page, int size
  );
}
