package com.valentin.ershov.service;

import com.valentin.ershov.domain.Price;
import com.valentin.ershov.repository.PriceRepository;
import com.valentin.ershov.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ershov-V-V on 20.12.2016.
 */
@Service
public class PriceServiceImpl extends AbstractService<Price, Integer> {

    @Autowired
    public PriceServiceImpl(PriceRepository repository) {
        super(repository);
    }

}
