package com.hana.app.repository;

import com.hana.app.data.entity.CateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CateRepository extends JpaRepository<CateEntity, Integer> {
}
