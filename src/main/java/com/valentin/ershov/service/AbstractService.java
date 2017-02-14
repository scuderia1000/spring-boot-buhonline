package com.valentin.ershov.service;

import com.valentin.ershov.repository.Repository;

import java.io.Serializable;

/**
 * Created by Valek on 14.02.2017.
 */
public abstract class AbstractService<T, K extends Serializable> {

    private Repository<T, K> repository;

    public AbstractService(Repository<T, K> repository) {
        this.repository = repository;
    }

    public Iterable<T> findAll() {
        return repository.findAll();
    }

    public T getById(K id) {
        return repository.findOne(id);
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public void delete(K id) {
        repository.delete(id);
    }
}
