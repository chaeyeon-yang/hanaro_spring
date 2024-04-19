package com.hana.app.repository;

import com.hana.app.data.entity.CateEntity;
import com.hana.app.data.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 스프링에 인식시키는거야 여기 레포지토리라는게 있어 인식해!~~~!!!
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

}
