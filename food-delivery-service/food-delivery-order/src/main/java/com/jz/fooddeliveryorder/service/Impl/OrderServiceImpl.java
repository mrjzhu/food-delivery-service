package com.jz.fooddeliveryorder.service.Impl;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.jz.fooddeliveryorder.domain.*;
import com.jz.fooddeliveryorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.crypto.Data;
import java.io.Console;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vagrant on 6/25/17.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Value("${URL.food-delivery-resturant}")
    String itemsUrl;

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ItemInfoRepository Itemrepository;

    @Override
    public List<Order> findAllOrders() {
        return this.repository.findAllBy();
    }

    @Override
    public void placeOrder(Order orderInfo) {
//        RestTemplate restTemplate = new RestTemplate();
//        String url = itemsUrl + "/RestaurantInfo/Dragon/Items";
//        Item[] totalItems = restTemplate.getForObject(url,Item[].class);
//
//        List<ItemInfo> itemInfos = new ArrayList<>();
//        for(Item item: totalItems){
//            orderInfo.setDeliveryAddress("2518 S, Street");
//            itemInfos.add(new ItemInfo(item.itemName,item.itemPrice, 3, "spicy,spicy,spicy!!"));
//        }
//        orderInfo.setItems(itemInfos);
        this.repository.save(orderInfo);
    }

    @Override
    public void deleteAll() {
        this.repository.deleteAll();
    }

    @Override
    public void deleteById(String orderId) {
        this.repository.deleteAllByOrderId(orderId);
    }

    @Override
    public Order findByOrderId(String orderId) {
        return this.repository.findByOrderId(orderId);
    }

    @Override
    public List<Item> getItemsByRestaurantName(String name) {
        RestTemplate restTemplate = new RestTemplate();
        String url = itemsUrl + "/RestaurantInfo/"+name+"/Items";
        Item[] totalItems = restTemplate.getForObject(url,Item[].class);
        List<Item> res = new ArrayList<Item>();
        for(Item n : totalItems)
            res.add(n);
        return res;

    }

    @Override
    public List<ItemInfo> displayAllItemsSelected() {
        return this.Itemrepository.findAllBy();
    }

    @Override
    public void saveItems(ItemInfo itemInfo) {
        this.Itemrepository.save(itemInfo);
    }

    @Override
    public void deleteAllItemsSelected() {
        this.Itemrepository.deleteAllBy();
    }

//    @Override
//    public List<String> getRestaurantName() {
//        RestTemplate restTemplate = new RestTemplate();
//        String url = itemsUrl;
//        String[] allName = restTemplate.getForObject(url,String[].class);
//        List<String> res = new ArrayList<String>();
//        for(String n : allName)
//            res.add(n);
//        return res;
//    }
}
