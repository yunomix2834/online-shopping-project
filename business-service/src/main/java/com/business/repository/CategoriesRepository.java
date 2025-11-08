package com.business.repository;

import com.business.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriesRepository
        extends JpaRepository<Category, String> {

    Optional<Category> findBySlug(String slug);

    @Query(value = """
       update categories 
          set deleted_at = null, deleted_by = null
        where id = :id
       """, nativeQuery = true)
    @Modifying
    int nativeRestore(@Param("id") String id);

    @Query("""
        select c from Category c
         where (:q is null or :q = ''
               or lower(c.name) like lower(concat('%', :q, '%'))
               or lower(c.slug) like lower(concat('%', :q, '%')) )
         order by c.createdAt desc
    """)
    Page<Category> search(@Param("q") String q, Pageable pageable);


    List<Category> findByParentIdOrderByNameAsc(String parentId);
}
