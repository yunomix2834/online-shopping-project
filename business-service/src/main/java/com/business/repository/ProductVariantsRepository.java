package com.business.repository;

import com.business.entity.ProductVariant;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductVariantsRepository
    extends JpaRepository<ProductVariant, String> {

  Optional<ProductVariant> findBySku(String sku);

  @Query(value = "update product_variants set deleted_at = null, deleted_by = null where variant_id = :id", nativeQuery = true)
  @Modifying
  int nativeRestore(@Param("id") String id);

  @Query("""
      select v from ProductVariant v
       where v.product.id = :productId
       order by v.createdAt desc
    """)
  Page<ProductVariant> listByProduct(
      @Param("productId") String productId,
      Pageable pageable);
}
