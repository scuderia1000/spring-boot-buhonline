package com.valentin.ershov;

import com.valentin.ershov.domain.Price;
import com.valentin.ershov.repository.PriceRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Ershov-V-V on 27.12.2016.
 */
//@Component
public class PriceLoader implements ApplicationListener<ContextRefreshedEvent> {
    private PriceRepository priceRepository;
    private Logger log = Logger.getLogger(PriceLoader.class);

    @Autowired
    public void setPriceRepository(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        Price firstPrice = new Price();
        firstPrice.setName("Opt");
        priceRepository.save(firstPrice);
        log.info("Saved price id: " + firstPrice.getId());
    }
}
