package com.jz.fooddeliverypayment.domain;

import lombok.Data;

/**
 * Created by vagrant on 6/29/17.
 */
@Data
public class Order {
    private String orderId;
    private double totalPrice;
}
