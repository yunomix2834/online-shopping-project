package com.business.repository;

import com.business.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemsRepository
    extends JpaRepository<CartItem, String> {

  @Query("""
     select ci from CartItem ci
      where ci.userId = :uid and ci.variant.id = :vid
  """)
  Optional<CartItem> findByUserAndVariant(
      @Param("uid") String userId,
      @Param("vid") String variantId);

  @Modifying
  @Query("delete from CartItem ci where ci.userId = :uid")
  int deleteAllByUserId(
      @Param("uid") String userId);

  @Query("""
     select ci from CartItem ci
      join fetch ci.variant v
      join fetch v.product p
     where ci.userId = :uid
     order by ci.id asc
  """)
  List<CartItem> listWithSnapshot(
      @Param("uid") String userId);
}
