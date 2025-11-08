package com.business.repository;

import com.business.entity.Attribute;
import com.business.entity.VariantAttributeValue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantAttributeValuesRepository
    extends JpaRepository<VariantAttributeValue, String> {

  @Query("""
      select (count(vav) > 0) from VariantAttributeValue vav
       where vav.variant.id = :variantId and vav.attribute.id = :attributeId
    """)
  boolean existsLink(
      @Param("variantId") String variantId,
      @Param("attributeId") String attributeId);

  @Modifying
  @Query("""
      delete from VariantAttributeValue vav
       where vav.variant.id = :variantId and vav.attribute.id = :attributeId
    """)
  int deleteLink(@Param("variantId") String variantId, @Param("attributeId") String attributeId);

  @Query("""
      select a from VariantAttributeValue vav join vav.attribute a
       where vav.variant.id = :variantId
       order by a.name asc
    """)
  Page<Attribute> listAttributes(
      @Param("variantId") String variantId,
      Pageable pageable);
}
