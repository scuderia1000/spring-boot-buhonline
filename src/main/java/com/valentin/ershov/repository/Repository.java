package com.valentin.ershov.repository;

import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * Created by Valek on 11.02.2017.
 */
public interface Repository<T, ID extends Serializable> extends CrudRepository<T, ID>{
}
