package com.business.repository;

import com.business.entity.ProductImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImagesRepository
    extends JpaRepository<ProductImage, String> {

  @Query(value = "update product_images set deleted_at = null, deleted_by = null where image_id = :id", nativeQuery = true)
  @Modifying
  int nativeRestore(
      @Param("id") String id);

  @Query("""
      select i from ProductImage i
       where (:productId is null or i.product.id = :productId)
         and (:variantId is null or i.variant.id = :variantId)
       order by i.createdAt desc
    """)
  Page<ProductImage> search(
      @Param("productId") String productId,
      @Param("variantId") String variantId,
      Pageable pageable);

  @Modifying
  @Query("""
      update ProductImage i set i.thumbnail = false
       where (:productId is null or i.product.id = :productId)
         and (:variantId is null or i.variant.id = :variantId)
         and i.thumbnail = true
    """)
  int unsetAllThumbnail(
      @Param("productId") String productId,
      @Param("variantId") String variantId);
}

