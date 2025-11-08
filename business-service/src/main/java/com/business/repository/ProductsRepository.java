package com.business.repository;

import com.business.constant.ProductStatus;
import com.business.entity.Product;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.*;

import java.util.Optional;

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

    @Query("""
      select p from Product p
       left join ProductCategory pc on pc.product.id = p.id
      where (:q is null or :q = '' 
             or lower(p.name) like lower(concat('%', :q, '%'))
             or lower(p.slug) like lower(concat('%', :q, '%'))
             or lower(p.description) like lower(concat('%', :q, '%')))
        and (:brandId is null or :brandId = '' or p.brand.id = :brandId)
        and (:categoryId is null or :categoryId = '' or pc.category.id = :categoryId)
        and (:status is null or p.status = :status)
      group by p
      order by p.createdAt desc
    """)
    Page<Product> filter(
            @Param("q") String q,
            @Param("brandId") String brandId,
            @Param("categoryId") String categoryId,
            @Param("status") ProductStatus status,
            Pageable pageable);
}
