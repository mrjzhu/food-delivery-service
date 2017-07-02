package com.jz.fooddeliveryorder.domain;

import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by vagrant on 6/25/17.
 */
@RepositoryRestResource(path = "OrderInfo")
public interface OrderRepository extends MongoRepository<Order,Long> {

    @RestResource(path = "Order")
    List<Order> findAllBy();

    @RestResource(path = "Order/Id")
    Order findByOrderId(String orderId);

    @RestResource(path = "delete")
    void deleteAllBy();

    @RestResource(path = "delete/Id")
    void deleteAllByOrderId(String orderId);
}
