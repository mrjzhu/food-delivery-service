package com.jz.fooddeliveryresturant.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by vagrant on 6/24/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Embeddable
@Data
public class ItemInfo {

    @Id
    @GeneratedValue
    private Long id;
    private String itemName;
    private double itemPrice;

    public ItemInfo(){

    }
    @JsonCreator
    public ItemInfo(@JsonProperty("itemName") String name,
                    @JsonProperty("itemPrice") double price){
        this.itemName = name;
        this.itemPrice = price;
    }
}