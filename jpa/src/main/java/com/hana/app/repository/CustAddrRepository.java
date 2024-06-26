package com.hana.app.repository;

import com.hana.app.data.entity.CustAddrEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustAddrRepository extends JpaRepository<CustAddrEntity, Long> {
}