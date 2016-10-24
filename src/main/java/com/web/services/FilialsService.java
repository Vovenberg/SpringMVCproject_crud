package com.web.services;

import com.web.entities.ClientsEntity;
import com.web.entities.FilialsEntity;
import com.web.repositories.FilialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vladimir on 04.10.2016.
 */
@Service
public class FilialsService implements DefaultInterface<FilialsEntity> {

    @Autowired
    FilialsRepository repository;

    @Override
    public void add(FilialsEntity entity) {
        repository.save(entity);

    }

    @Override
    public void delete(Long l) {
        repository.delete(repository.findOne(l));

    }

    @Override
    public void update(FilialsEntity entity) {
        repository.save(entity);
    }

    @Override
    public FilialsEntity getById(Long l) {
        try {
            return repository.findOne(l);
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public List<FilialsEntity> getAll() {
        return repository.findAll();
    }
}
