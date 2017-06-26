package com.jz.fooddeliveryorder.controller;

import com.jz.fooddeliveryorder.domain.Order;
import com.jz.fooddeliveryorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vagrant on 6/25/17.
 */
@RestController
public class OrderServiceController {

    private OrderService service;


    @Autowired
    public OrderServiceController(OrderService service) {
        this.service = service;
    }

    @RequestMapping(value = "/OrderService", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<Order> orders){
        this.service.placeOrder(orders);
    }

    @RequestMapping(value = "/OrderService", method = RequestMethod.DELETE)
    void delete(){
        this.service.deleteAll();
    }


    @RequestMapping(value = "/OrderService", method = RequestMethod.GET)
    public List<Order> findAll(){
        return this.service.findAllOders();
    }
}
