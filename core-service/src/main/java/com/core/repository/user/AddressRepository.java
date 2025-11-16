package com.core.repository.user;

import com.core.entity.Address;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
  @Query("""
      select a from Address a
      where a.user.id = :userId and a.deletedAt is null
      order by a.createdAt desc""")
  List<Address> findByUserId(@Param("userId") String userId);

  @Modifying
  @Query("""
      update Address a
      set a.isDefaultShipping = false
      where a.user.id = :userId and a.deletedAt is null""")
  void resetDefaultShipping(@Param("userId") String userId);

  @Modifying
  @Query("""
      update Address a
      set a.isDefaultBilling = false
      where a.user.id = :userId and a.deletedAt is null""")
  void resetDefaultBilling(@Param("userId") String userId);
}
