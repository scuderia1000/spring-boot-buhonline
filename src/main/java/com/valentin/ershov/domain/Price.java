package com.valentin.ershov.domain;

import javax.persistence.*;

/**
 * Created by Ershov-V-V on 20.12.2016.
 */
@Entity
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String unit;

    private boolean isCalculated;

    public boolean getIsCalculated() {
        return isCalculated;
    }

    public void setIsCalculated(boolean calculated) {
        isCalculated = calculated;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
