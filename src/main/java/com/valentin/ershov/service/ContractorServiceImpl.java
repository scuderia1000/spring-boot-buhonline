package com.valentin.ershov.service;

import com.valentin.ershov.domain.Contractor;
import com.valentin.ershov.repository.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Valek on 16.02.2017.
 */
@Service
public class ContractorServiceImpl extends AbstractService<Contractor, Integer> {

    @Autowired
    public ContractorServiceImpl(ContractorRepository repository) {
        super(repository);
    }
}
