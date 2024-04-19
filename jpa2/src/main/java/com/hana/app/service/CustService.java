package com.hana.app.service;

import com.hana.app.data.entity.CustEntity;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CustRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustService implements HanaService<CustEntity, String> {

    private final CustRepository repository;

    @Override
    public CustEntity insert(CustEntity entity) {
        return repository.save(entity);
    }

    @Override
    public Boolean delete(String string) {
        repository.deleteById(string);
        return true;
    }

    @Override
    public CustEntity update(CustEntity entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<CustEntity> get(String string) {
        return repository.findById(string);
    }

    @Override
    public List<CustEntity> get() {
        return repository.findAll();
    }
}
