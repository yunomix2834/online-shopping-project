package com.business.repository;

import com.business.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderItemsRepository
    extends JpaRepository<OrderItem, String> {

  @Query("""
     select oi from OrderItem oi
      join fetch oi.variant v
      join fetch oi.order o
     where oi.order.id = :oid
     order by oi.id asc
  """)
  List<OrderItem> listByOrder(
      @Param("oid") String orderId);
}
