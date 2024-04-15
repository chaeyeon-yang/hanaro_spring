package com.hana.app.repository;

import com.hana.app.data.entity.LoginCust;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
// value, key
public interface LoginCustRepository extends CrudRepository<LoginCust,String> {
}