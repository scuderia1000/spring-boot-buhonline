package com.valentin.ershov.service;

import com.valentin.ershov.domain.Price;
import com.valentin.ershov.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ershov-V-V on 20.12.2016.
 */
@Service
public class PriceServiceImpl implements PriceService {
    private PriceRepository priceRepository;

    @Autowired
    public void setPriceRepository(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Iterable<Price> listAllPrices() {
        return priceRepository.findAll();
    }

    @Override
    public Price getPriceById(Integer id) {
        return priceRepository.findOne(id);
    }

    @Override
    public Price savePrice(Price price) {
        return priceRepository.save(price);
    }

    @Override
    public void deletePrice(Integer id) {
        priceRepository.delete(id);
    }
}
