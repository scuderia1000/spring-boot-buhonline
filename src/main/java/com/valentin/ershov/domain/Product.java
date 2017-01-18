package com.valentin.ershov.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Ershov-V-V on 12.01.2017.
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Integer id;
    private String name;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "product_price_value",
//        joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "product_id"),
//        inverseJoinColumns = @JoinColumn(name = "price_id", referencedColumnName = "price_id"))
//    private Set<Price> prices = new HashSet<Price>();

    @OneToMany(mappedBy = "primaryKey.product", cascade = CascadeType.ALL)
    private Set<ProductPrice> productPrices = new HashSet<>();
//@OneToMany(mappedBy = "product")
//    private Set<ProductPrice> productPrices = new HashSet<>();

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

//    public Set<Price> getPrices() {
//        return prices;
//    }
//
//    public void setPrices(Set<Price> prices) {
//        this.prices = prices;
//    }

    public boolean hasPrice(Price price) {
        for (ProductPrice productPrice : productPrices) {
            if (productPrice.getPrice().getId().equals(price.getId())) {
                return true;
            }
        }
        return false;
    }

    public Set<ProductPrice> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(Set<ProductPrice> productPrices) {
        this.productPrices = productPrices;
    }
}
