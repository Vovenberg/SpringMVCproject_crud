package com.web.services;

import com.web.entities.OperationsEntity;
import com.web.repositories.OperationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vladimir on 04.10.2016.
 */
@Service
public class OperationsService implements DefaultInterface<OperationsEntity> {

    @Autowired
    OperationsRepository repository;

    @Override
    public void add(OperationsEntity entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long l) {
        repository.delete(l);
    }

    @Override
    public void update(OperationsEntity entity) {
        repository.save(entity);
    }

    @Override
    public OperationsEntity getById(Long l) {
        try {
            return repository.findOne(l);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<OperationsEntity> getAll() {
        return repository.findAll();
    }
}
