package com.valentin.ershov.service;

import com.valentin.ershov.domain.ProductPrice;
import com.valentin.ershov.repository.ProductPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ershov-V-V on 17.01.2017.
 */
@Service
public class ProductPriceServiceImpl implements ProductPriceService {

    private ProductPriceRepository productPriceRepository;

    @Autowired
    public void setProductPriceRepository(ProductPriceRepository productPriceRepository) {
        this.productPriceRepository = productPriceRepository;
    }

    @Override
    public Iterable<ProductPrice> listAllProductPrices() {
        return productPriceRepository.findAll();
    }

    @Override
    public ProductPrice getProductPriceById(Integer id) {
        return productPriceRepository.findOne(id);
    }

    @Override
    public ProductPrice saveProductPrice(ProductPrice productPrice) {
        return productPriceRepository.save(productPrice);
    }

    @Override
    public void deleteProductPrice(Integer id) {
        productPriceRepository.delete(id);
    }
}
