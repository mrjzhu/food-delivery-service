package com.jz.fooddeliveryorder.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by vagrant on 6/25/17.
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Item {
    public String itemName;
    public double itemPrice;

    @JsonCreator
    public Item(@JsonProperty("itemName") String itemName,
                @JsonProperty("itemPrice") double itemPrice){
        this.itemPrice = itemPrice;
        this.itemName = itemName;
    }

}
