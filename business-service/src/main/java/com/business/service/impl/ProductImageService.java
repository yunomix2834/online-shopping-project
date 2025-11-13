package com.business.service.impl;

import com.business.dto.request.ImageCreateRequestDto;
import com.business.dto.response.ImageResponseDto;
import com.business.entity.ProductImage;
import com.business.helper.AuthenticationHelper;
import com.business.mapper.ProductImageMapper;
import com.business.repository.ProductImagesRepository;
import com.business.repository.ProductVariantsRepository;
import com.business.repository.ProductsRepository;
import com.business.service.IProductImageService;
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
public class ProductImageService implements IProductImageService {
  ProductImagesRepository imagesRepo;
  ProductsRepository productsRepo;
  ProductVariantsRepository variantsRepo;
  ProductImageMapper mapper;

  @Override
  public void create(ImageCreateRequestDto dto) {
    AuthenticationHelper.requireAdmin();
    ProductImage i = mapper.toProductImageFromImageCreateRequestDto(dto);
    if (dto.getProductId() != null) productsRepo.findById(dto.getProductId())
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    if (dto.getVariantId() != null) variantsRepo.findById(dto.getVariantId())
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    imagesRepo.save(i);
  }
  @Override
  public void softDelete(String id) {
    AuthenticationHelper.requireAdmin();
    ProductImage i = imagesRepo.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    i.markDeleted(AuthenticationHelper.getMyUserId());
    imagesRepo.save(i);
  }
  @Override
  public void restore(String id) {
    AuthenticationHelper.requireAdmin();
    if (imagesRepo.nativeRestore(id)==0) {
      throw new AppException(ErrorCode.RESOURCE_NOT_FOUND);
    }
  }
  @Override
  public void setThumbnail(String id) {
    AuthenticationHelper.requireAdmin();
    ProductImage i = imagesRepo.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    String productId = i.getProduct() != null
        ? i.getProduct().getId()
        : null;
    String variantId = i.getVariant() != null
        ? i.getVariant().getId()
        : null;
    imagesRepo.unsetAllThumbnail(productId, variantId);
    i.setThumbnail(true);
    imagesRepo.save(i);
  }
  @Override
  public void unsetThumbnail(String id) {
    AuthenticationHelper.requireAdmin();
    ProductImage i = imagesRepo.findById(id)
        .orElseThrow(() -> new AppException(ErrorCode.RESOURCE_NOT_FOUND));
    i.setThumbnail(false);
    imagesRepo.save(i);
  }
  @Override
  public Envelope.Page<ImageResponseDto> list(
      String productId,
      String variantId,
      int page, int size) {
    Page<ProductImage> p = imagesRepo.search(
        productId,
        variantId,
        PageRequest.of(page, size)
    );
    List<ImageResponseDto>
        docs = p.getContent()
        .stream()
        .map(mapper::toImageResponseDtoFromProductImage)
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
