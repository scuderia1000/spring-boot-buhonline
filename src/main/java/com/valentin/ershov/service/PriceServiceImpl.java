package com.valentin.ershov.service;

import com.valentin.ershov.domain.Price;
import com.valentin.ershov.repository.PriceRepository;
import com.valentin.ershov.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ershov-V-V on 20.12.2016.
 */
@Service
public class PriceServiceImpl extends AbstractService<Price, Integer> {

//    private PriceRepository priceRepository;

//    private Repository<Price, Integer> priceRepository;

    @Autowired
    public PriceServiceImpl(PriceRepository repository) {
        super(repository);
    }


//    @Autowired
//    public void setPriceRepository(Repository<Price, Integer> priceRepository) {
//        this.priceRepository = priceRepository;
//    }

//    @Autowired
//    public void setPriceService(Repository<Price, Integer> priceRepository) {
//        this.priceRepository = priceRepository;
//    }

//    @Override
//    public Iterable<Price> listAllPrices() {
//        return priceRepository.findAll();
//    }
//
//    @Override
//    public Price getPriceById(Integer id) {
//        return priceRepository.findOne(id);
//    }
//
//    @Override
//    public Price savePrice(Price price) {
//        return priceRepository.save(price);
//    }
//
//    @Override
//    public void deletePrice(Integer id) {
//        priceRepository.delete(id);
//    }
}
