package com.valentin.ershov.service;

import com.valentin.ershov.domain.Price;

/**
 * Created by Ershov-V-V on 20.12.2016.
 */
public interface PriceService {
    Iterable<Price> listAllPrices();

    Price getPriceById(Integer id);

    Price savePrice(Price price);

    void deletePrice(Integer id);
}
