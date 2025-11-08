package com.business.repository;

import com.business.entity.Discount;
import java.time.Instant;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountsRepository extends JpaRepository<Discount, String> {

  Optional<Discount> findByCode(String code);

  @Query(value = "update discounts set deleted_at = null, deleted_by = null where discount_id = :id", nativeQuery = true)
  @Modifying
  int nativeRestore(
      @Param("id") String id);

  @Query("""
      select d from Discount d
       where (:only = false
              or (d.active = true
                  and (d.startDate is null or d.startDate <= :at)
                  and (d.endDate is null or d.endDate >= :at)))
       order by d.createdAt desc
    """)
  Page<Discount> listEffective(
      @Param("only") boolean only,
      @Param("at") Instant at,
      Pageable pageable);
}
