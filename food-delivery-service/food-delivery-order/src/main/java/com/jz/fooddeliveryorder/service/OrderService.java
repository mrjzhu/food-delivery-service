package com.jz.fooddeliveryorder.service;

import com.jz.fooddeliveryorder.domain.Order;

import java.util.List;

/**
 * Created by vagrant on 6/25/17.
 */
public interface OrderService {
    List<Order> findAllOders();
    void placeOrder(List<Order> orders);
    void deleteAll();
}
