package com.valentin.ershov.service;

import com.valentin.ershov.domain.Unit;
import com.valentin.ershov.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ershov-V-V on 28.12.2016.
 */
@Service
public class UnitServiceImpl extends AbstractService<Unit, Integer> {

    @Autowired
    public UnitServiceImpl(UnitRepository repository) {
        super(repository);
    }
}
