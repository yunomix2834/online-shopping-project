package com.core.repository.user;

import com.core.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoleRepository
    extends JpaRepository<Role, String> {

  @Modifying
  @Transactional
  @Query(value = """
      update roles
      set deleted_at = null,
          deleted_by = null
      where name = :name
      """, nativeQuery = true)
  int nativeRestore(@Param("name") String name);

  boolean existsById(String name);
}
