package com.valentin.ershov.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ershov-V-V on 20.12.2016.
 */
@Entity
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "price_id")
    private Integer id;
    private String name;
    private String unit;
    private boolean isCalculated;
    private Integer base_price_id;
    private Integer multipler;

//    @ManyToMany
//    @JoinTable(name = "product_price_value",
//        joinColumns = @JoinColumn(name = "price_id"),
//        inverseJoinColumns = @JoinColumn(name = "product_id"))
//    private Set<Product> products = new HashSet<Product>();

    @OneToMany(mappedBy = "primaryKey.price", cascade = CascadeType.ALL, orphanRemoval=true)
    private Set<ProductPrice> productPrices = new HashSet<>();

    public Integer getBase_price_id() {
        return base_price_id;
    }

    public void setBase_price_id(Integer base_price_id) {
        this.base_price_id = base_price_id;
    }

    public Integer getMultipler() {
        return multipler;
    }

    public void setMultipler(Integer multipler) {
        this.multipler = multipler;
    }

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

    public Set<ProductPrice> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(Set<ProductPrice> productPrices) {
        this.productPrices = productPrices;
    }
}
