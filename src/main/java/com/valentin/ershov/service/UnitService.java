package com.valentin.ershov.service;

import com.valentin.ershov.domain.Unit;

/**
 * Created by Ershov-V-V on 28.12.2016.
 */
public interface UnitService {
    Iterable<Unit> listAllUnits();

    Unit getUnitById(Integer id);

    Unit saveUnit(Unit unit);

    void deleteUnit(Integer id);
}
