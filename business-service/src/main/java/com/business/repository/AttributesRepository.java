package com.business.repository;

import com.business.entity.Attribute;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributesRepository
    extends JpaRepository<Attribute, String> {

  @Query(value = "update attributes set deleted_at = null, deleted_by = null where attribute_id = :id", nativeQuery = true)
  @Modifying
  int nativeRestore(@Param("id") String id);

  @Query("""
      select a from Attribute a
       where (:q is null or :q = '' or lower(a.name) like lower(concat('%', :q, '%')) or lower(a.value) like lower(concat('%', :q, '%')))
       order by a.createdAt desc
    """)
  Page<Attribute> search(@Param("q") String q, Pageable pageable);
}
