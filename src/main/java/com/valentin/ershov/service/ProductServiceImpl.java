package com.valentin.ershov.service;

import com.valentin.ershov.domain.Product;
import com.valentin.ershov.repository.ProductRepository;
import com.valentin.ershov.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ershov-V-V on 12.01.2017.
 */
@Service
public class ProductServiceImpl extends AbstractService<Product, Integer> {

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        super(repository);
    }
}
