package com.web.services;

import com.web.entities.CardsEntity;
import com.web.repositories.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vladimir on 04.10.2016.
 */
@Service
public class CardsService implements DefaultInterface<CardsEntity> {

    @Autowired
    CardsRepository repository;

    @Override
    public void add(CardsEntity entity) {
        repository.save(entity);

    }

    @Override
    public void delete(Long l) {
        repository.delete(l);

    }

    @Override
    public void update(CardsEntity entity) {
        repository.save(entity);
    }

    @Override
    public CardsEntity getById(Long l) {
        try {
            return repository.findOne(l);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<CardsEntity> getAll() {
        return repository.findAll();
    }
}
