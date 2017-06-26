package com.jz.fooddeliveryresturant.service;

import com.jz.fooddeliveryresturant.domain.ResturantInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vagrant on 6/24/17.
 */
public interface RestaurantInfoService {
    void saveRestaurantInfo(List<ResturantInfo> restaurantInfos);
    List<ResturantInfo> findByName (String name);
    void deleteAll();
}
