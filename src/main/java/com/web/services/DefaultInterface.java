package com.web.services;

import com.web.entities.ClientsEntity;

import java.util.List;

/**
 * Created by Vladimir on 21.09.2016.
 */
public interface DefaultInterface<T> {
    void add (ClientsEntity entity);
    void delete (Long l);
    void update (ClientsEntity entity);
    T getById (Long l);
    List<T> getAll ();
}
