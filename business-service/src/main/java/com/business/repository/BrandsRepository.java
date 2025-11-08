package com.business.repository;

import com.business.entity.Brand; // entity sẵn có
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandsRepository
        extends JpaRepository<Brand, String> {

    Optional<Brand> findBySlug(String slug);

    @Query(value = """
       update brands 
          set deleted_at = null, deleted_by = null
        where id = :id
       """, nativeQuery = true)
    @Modifying
    int nativeRestore(@Param("id") String id);

    @Query(value = """
        select b from Brand b
         where ( :q is null or :q = '' 
                 or lower(b.name) like lower(concat('%', :q, '%'))
                 or lower(b.slug) like lower(concat('%', :q, '%')) )
        order by b.createdAt desc
       """)
    Page<Brand> search(@Param("q") String q, Pageable pageable);
}
