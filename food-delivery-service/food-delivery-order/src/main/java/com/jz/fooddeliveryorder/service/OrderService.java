package com.jz.fooddeliveryorder.service;

import com.jz.fooddeliveryorder.domain.Item;
import com.jz.fooddeliveryorder.domain.ItemInfo;
import com.jz.fooddeliveryorder.domain.Order;

import java.util.List;

/**
 * Created by vagrant on 6/25/17.
 */
public interface OrderService {
    List<Order> findAllOrders();
    void placeOrder(Order orders);
    void deleteAll();
    void deleteById(String orderId);
    Order findByOrderId(String orderId);

    List<Item> getItemsByRestaurantName(String name);

    List<ItemInfo> displayAllItemsSelected();
    void saveItems(ItemInfo itemInfo);
    void deleteAllItemsSelected();
}
