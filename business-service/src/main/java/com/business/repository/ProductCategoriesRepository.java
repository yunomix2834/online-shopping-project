package com.business.repository;

import com.business.entity.ProductCategory;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoriesRepository
        extends JpaRepository<ProductCategory, String> {

    @Query("""
      select count(pc) > 0 from ProductCategory pc
       where pc.product.id = :productId and pc.category.id = :categoryId
    """)
    boolean existsLink(
            @Param("productId") String productId,
            @Param("categoryId") String categoryId
    );

    @Modifying
    @Query("""
      delete from ProductCategory pc
       where pc.product.id = :productId and pc.category.id = :categoryId
    """)
    int deleteLink(
            @Param("productId") String productId,
            @Param("categoryId") String categoryId
    );
}
