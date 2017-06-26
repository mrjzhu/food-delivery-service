package com.jz.fooddeliveryresturant.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Generated;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vagrant on 6/24/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Document
public class ResturantInfo {

    @Id
    @GeneratedValue
    private String id;
    private String name;
    private String desciption;

    private List<ItemInfo> menuItems;

    private ItemInfo items;
//    public ResturantInfo(List<ItemInfo> menuItemList) {this.menuItemList = menuItemList;}

    @JsonCreator
    public ResturantInfo(@JsonProperty("Id") String id,
                        @JsonProperty("Name") String name,
                         @JsonProperty("Description") String desciption,
                        @JsonProperty("menuItems") List<ItemInfo> menuItems){
        this.id = id;
        this.name = name;
        this.desciption = desciption;
        this.menuItems = new ArrayList<>(menuItems);
    }




}
