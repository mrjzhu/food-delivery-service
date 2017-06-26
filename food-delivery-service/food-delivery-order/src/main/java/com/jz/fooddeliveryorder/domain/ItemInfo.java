package com.jz.fooddeliveryorder.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * Created by vagrant on 6/25/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Document
public class ItemInfo {

    public Item item;
    public int quantity;
    public String note;

    public ItemInfo(){};
    @JsonCreator
    public ItemInfo(@JsonProperty("item") Item item,
                     @JsonProperty("quantity") int quantity,
                     @JsonProperty("note") String note){
        this.item = item;
        this.quantity = quantity;
        this.note = note;
    }
}
