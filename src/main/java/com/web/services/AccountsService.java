package com.web.services;

import com.web.entities.AccountsEntity;
import com.web.entities.ClientsEntity;
import com.web.repositories.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Vladimir on 04.10.2016.
 */
@Service
public class AccountsService implements DefaultInterface<AccountsEntity> {

    @Autowired
    AccountsRepository repository;


    @Override
    public void add(AccountsEntity entity) {
        repository.save(entity);

    }

    @Override
    public void delete(Long l) {
        repository.delete(repository.findOne(l));

    }

    @Override
    public void update(AccountsEntity entity) {
        repository.save(entity);
    }

    @Override
    public AccountsEntity getById(Long l) {
        return repository.getOne(l);
    }

    @Override
    public List<AccountsEntity> getAll() {
        return repository.findAll();
    }
}
