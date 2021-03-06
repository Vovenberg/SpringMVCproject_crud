package com.web.services;

import com.web.entities.ClientsEntity;
import com.web.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vladimir on 21.09.2016.
 */
@Service
public class ClientsService implements DefaultInterface<ClientsEntity> {

    @Autowired
    ClientRepository repository;

    @Override
    public void add(ClientsEntity entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long l) {
        repository.delete(l);
    }

    @Override
    public void update(ClientsEntity entity) {
        repository.save(entity);
    }

    @Override
    public ClientsEntity getById(Long l) {
        try {
            return repository.findOne(l);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<ClientsEntity> getAll() {
        return repository.findAll();
    }

}
