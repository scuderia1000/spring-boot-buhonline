package com.valentin.ershov.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Ershov-V-V on 17.01.2017.
 */
@Entity
@Table(name = "products_prices")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.product",
            joinColumns = @JoinColumn(name = "product_id")),
    @AssociationOverride(name = "primaryKey.price",
            joinColumns = @JoinColumn(name = "price_id"))})
public class ProductPrice {
    // Composite-id key
    @EmbeddedId
    private ProductPriceId primaryKey = new ProductPriceId();

    // Extra fields
    private Long value;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    public ProductPrice() {
    }

    public ProductPrice(Product product, Price price, Long value, Date createdDate) {
        setProduct(product);
        setPrice(price);
        this.value = value;
        this.createdDate = createdDate;
    }

    public ProductPriceId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(ProductPriceId primaryKey) {
        this.primaryKey = primaryKey;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Transient
    public Product getProduct() {
        return this.primaryKey.getProduct();
    }

    public void setProduct(Product product) {
        getPrimaryKey().setProduct(product);
    }

    @Transient
    public Price getPrice() {
        return this.primaryKey.getPrice();
    }

    public void setPrice(Price price) {
        getPrimaryKey().setPrice(price);
    }

    /*
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_price_id", insertable = false, updatable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "price_id")
    private Price price;

    private long value;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date productPriceCreatedDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
*/
}
