package com.valentin.ershov.domain;

import javax.persistence.*;

/**
 * Created by Ershov-V-V on 27.12.2016.
 */
@Entity
@Table(name = "units")
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

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
