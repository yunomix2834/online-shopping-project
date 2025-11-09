package com.business.repository;

import com.business.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartsRepository
    extends JpaRepository<Cart, String> {

  @Query(value = "update carts set deleted_at = null, deleted_by = null where user_id = :uid", nativeQuery = true)
  @Modifying
  int nativeRestore(
      @Param("uid") String userId);
}
