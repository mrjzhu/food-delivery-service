package com.jz.fooddeliveryresturant.service.impl;

import com.jz.fooddeliveryresturant.domain.ItemInfo;
import com.jz.fooddeliveryresturant.domain.ResturantInfo;
import com.jz.fooddeliveryresturant.domain.ResturantInfoRepository;
import com.jz.fooddeliveryresturant.service.RestaurantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vagrant on 6/24/17.
 */
@Service
public class RestaurantInfoServiceImpl implements RestaurantInfoService{

    @Autowired
    private ResturantInfoRepository repository;


    @Override
    public void saveRestaurantInfo(List<ResturantInfo> restaurantInfos) {
        this.repository.save(restaurantInfos);
    }

    @Override
    public List<ResturantInfo> findByName(String name) {
        return repository.findAllByName(name);
    }

    @Override
    public void deleteAll() {
        this.repository.deleteAll();
    }
}
