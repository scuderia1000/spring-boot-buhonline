package com.valentin.ershov.service;

import com.valentin.ershov.domain.Product;
import com.valentin.ershov.domain.ProductPrice;

/**
 * Created by Ershov-V-V on 12.01.2017.
 */
public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(Integer id);

    Product saveProduct(Product product);

    void deleteProduct(Integer id);
}
