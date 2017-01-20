package com.valentin.ershov.service;

import com.valentin.ershov.domain.ProductPrice;

/**
 * Created by Ershov-V-V on 12.01.2017.
 */
public interface ProductPriceService {
    Iterable<ProductPrice> listAllProductPrices();

    ProductPrice getProductPriceById(Integer id);

    ProductPrice saveProductPrice(ProductPrice productPrice);

    void deleteProductPrice(Integer id);

    void deleteProductPrice(ProductPrice productPrice);
}
