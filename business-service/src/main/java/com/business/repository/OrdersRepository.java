package com.business.repository;

import com.business.constant.OrderStatus;
import com.business.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.Instant;

@Repository
public interface OrdersRepository
    extends JpaRepository<Order, String> {

  @Query("""
     select o from Order o
      where o.userId = :uid
        and (:status is null or o.status = :status)
        and (:from is null or o.createdAt >= :from)
        and (:to is null or o.createdAt < :to)
     order by o.createdAt desc
  """)
  Page<Order> filter(
      @Param("uid") String userId,
      @Param("status") OrderStatus status,
      @Param("from") Instant from,
      @Param("to") Instant to,
      Pageable pageable);
}
