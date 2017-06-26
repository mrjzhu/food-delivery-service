package com.jz.fooddeliveryorder.service.Impl;

import com.jz.fooddeliveryorder.domain.Order;
import com.jz.fooddeliveryorder.domain.OrderRepository;
import com.jz.fooddeliveryorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vagrant on 6/25/17.
 */
@Service
public class OrderServiceImpl implements OrderService {



    @Autowired
    private OrderRepository repository;

    @Override
    public List<Order> findAllOders() {
        return this.repository.findAllBy();
    }

    @Override
    public void placeOrder(List<Order> orderInfo) {
        this.repository.save(orderInfo);
    }

    @Override
    public void deleteAll() {
        this.repository.deleteAll();
    }
}
