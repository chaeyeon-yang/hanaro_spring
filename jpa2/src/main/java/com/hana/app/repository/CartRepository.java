package com.hana.app.repository;

import com.hana.app.data.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer> {
    // mapper없이 자동으로 불러옴
    List<CartEntity> findByCustId(String id);
}
