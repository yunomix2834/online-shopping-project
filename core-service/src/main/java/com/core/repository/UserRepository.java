package com.core.repository;

import com.core.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
    extends JpaRepository<User, String> {

  @Query("""
          select u from User u
          left join fetch u.roles r
          where u.username = :username or u.email = :email
      """)
  Optional<User> findByUsernameOrEmail(
      @Param("username") String username,
      @Param("email") String email);

  boolean existsByEmail(String email);

  boolean existsByUsername(String username);

  Optional<User> findByUsername(String username);

  Optional<User> findByEmail(String email);
}
