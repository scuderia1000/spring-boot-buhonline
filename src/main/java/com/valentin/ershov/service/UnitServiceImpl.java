package com.valentin.ershov.service;

import com.valentin.ershov.domain.Unit;
import com.valentin.ershov.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ershov-V-V on 28.12.2016.
 */
@Service
public class UnitServiceImpl implements UnitService {
    private UnitRepository unitRepository;

    @Autowired
    public void setUnitRepository(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public Iterable<Unit> listAllUnits() {
        return unitRepository.findAll();
    }

    @Override
    public Unit getUnitById(Integer id) {
        return unitRepository.findOne(id);
    }

    @Override
    public Unit saveUnit(Unit unit) {
        return unitRepository.save(unit);
    }

    @Override
    public void deleteUnit(Integer id) {
        unitRepository.delete(id);
    }
}
