package com.jz.fooddeliveryorder.domain;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by vagrant on 6/25/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Document
public class Order {
    @Id
    @GeneratedValue
    private String orderId;

    private List<ItemInfo> items;
    private String date;

    private String deliveryAddress;

    private double totalPrice;

    private ItemInfo itemInfo;

    @JsonCreator
    public Order(@JsonProperty("orderId") String orderId,
                 @JsonProperty("items") List<ItemInfo> items,
                 @JsonProperty("date") String date,
                 @JsonProperty("deliveryAddress") String deliveryAddress,
                 @JsonProperty("totalPrice") double totalPrice){
//        this.orderId = orderId;
        this.items = new ArrayList<ItemInfo>(items);
        this.date = new Date().toString();
        this.deliveryAddress = deliveryAddress;
        for(ItemInfo n : items){
            this.totalPrice += n.itemPrice * n.quantity;
        }
    }
}
