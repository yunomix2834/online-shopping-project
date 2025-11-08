package com.business.service;

import com.business.dto.request.ImageCreateRequestDto;
import com.business.dto.response.ImageResponseDto;
import org.common.http.Envelope;

public interface IProductImageService {
  void create(ImageCreateRequestDto dto);
  void softDelete(String id);
  void restore(String id);
  void setThumbnail(String id);
  void unsetThumbnail(String id);
  Envelope.Page<ImageResponseDto> list(
      String productId,
      String variantId,
      int page, int size
  );
}
