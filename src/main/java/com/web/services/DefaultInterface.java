package com.web.services;

import java.util.List;

/**
 * Created by Vladimir on 21.09.2016.
 */
public interface DefaultInterface<T> {
    void add(T entity);

    void delete(Long l);

    void update(T entity);

    T getById(Long l);

    List<T> getAll();
}
