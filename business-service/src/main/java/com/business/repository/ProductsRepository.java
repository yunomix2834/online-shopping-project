package com.business.repository;

import com.business.constant.ProductStatus;
import com.business.entity.Product;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository
        extends JpaRepository<Product, String> {

    Optional<Product> findBySlug(String slug);

    @Query(value = """
       update products
          set deleted_at = null, deleted_by = null
        where id = :id
       """, nativeQuery = true)
    @Modifying
    int nativeRestore(@Param("id") String id);

    @Query(
        value = """
      select p.*
        from products p
       where (:q is null or :q = ''
              or lower(p.name)        like lower(concat('%', :q, '%'))
              or lower(p.slug)        like lower(concat('%', :q, '%'))
              or lower(p.description) like lower(concat('%', :q, '%')))
         and (:brandId    is null or :brandId = '' or p.brand_id = :brandId)
         and (:status     is null or p.status = :status)  -- Xem ghi chú bên dưới
         and (:categoryId is null or :categoryId = '' or exists (
                select 1
                  from product_categories pc
                 where pc.product_id  = p.id
                   and pc.category_id = :categoryId
             ))
       order by p.created_at desc
    """,
        countQuery = """
      select count(*)
        from products p
       where (:q is null or :q = ''
              or lower(p.name)        like lower(concat('%', :q, '%'))
              or lower(p.slug)        like lower(concat('%', :q, '%'))
              or lower(p.description) like lower(concat('%', :q, '%')))
         and (:brandId    is null or :brandId = '' or p.brand_id = :brandId)
         and (:status     is null or p.status = :status)
         and (:categoryId is null or :categoryId = '' or exists (
                select 1
                  from product_categories pc
                 where pc.product_id  = p.id
                   and pc.category_id = :categoryId
             ))
    """,
        nativeQuery = true
    )
    Page<Product> filter(
            @Param("q") String q,
            @Param("brandId") String brandId,
            @Param("categoryId") String categoryId,
            @Param("status") ProductStatus status,
            Pageable pageable);
}
