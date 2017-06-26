package com.jz.fooddeliveryresturant.controller;

import com.jz.fooddeliveryresturant.domain.ResturantInfo;
import com.jz.fooddeliveryresturant.service.RestaurantInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vagrant on 6/24/17.
 */
@RestController
public class ResturantInfoController {

    private RestaurantInfoService service;


    @Autowired
    public ResturantInfoController(RestaurantInfoService service) {
        this.service = service;
    }

    @RequestMapping(value = "/RestaurantInfo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<ResturantInfo> resturantInfos){
        this.service.saveRestaurantInfo(resturantInfos);
    }

    @RequestMapping(value = "/RestaurantInfo", method = RequestMethod.DELETE)
    void delete(){
        this.service.deleteAll();
    }


    @RequestMapping(value = "/RestaurantInfo/{name}", method = RequestMethod.GET)
    public List<ResturantInfo> findRestaurant(@PathVariable String name){
        return this.service.findByName(name);
    }
}
