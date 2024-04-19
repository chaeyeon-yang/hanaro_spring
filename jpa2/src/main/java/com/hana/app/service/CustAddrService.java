package com.hana.app.service;

import com.hana.app.data.entity.CustAddrEntity;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CustAddrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustAddrService implements HanaService<CustAddrEntity, Integer> {

    final CustAddrRepository repository;
    @Override
    public CustAddrEntity insert(CustAddrEntity custAddrEntity) {
        return repository.save(custAddrEntity);
    }

    @Override
    public Boolean delete(Integer integer) {
        repository.deleteById(integer);
        return true;
    }

    @Override
    public CustAddrEntity update(CustAddrEntity custAddrEntity) {
        return repository.save(custAddrEntity);
    }

    @Override
    public Optional<CustAddrEntity> get(Integer integer) {
        return repository.findById(integer);
    }

    @Override
    public List<CustAddrEntity> get() {
        return repository.findAll();
    }
}
