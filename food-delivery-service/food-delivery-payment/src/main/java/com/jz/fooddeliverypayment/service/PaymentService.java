package com.jz.fooddeliverypayment.service;

import com.jz.fooddeliverypayment.domain.Payment;

import java.util.List;

/**
 * Created by vagrant on 6/25/17.
 */
public interface PaymentService {
     List<Payment> findALl();
     void deleteAll();
     void savePayment(Payment payment);

}
