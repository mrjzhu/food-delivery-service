package com.jz.fooddeliverypayment.controller;

import com.jz.fooddeliverypayment.domain.Payment;
import com.jz.fooddeliverypayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vagrant on 6/25/17.
 */
@RestController
public class PaymentServiceController {

    private PaymentService service;

    @Autowired
    public PaymentServiceController(PaymentService service) {
        this.service = service;
    }

    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void savePaymentInfo(@RequestBody Payment payment){
        this.service.savePayment(payment);
    }

    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public List<Payment> findAllPayment(){
        return this.service.findALl();
    }

    @RequestMapping(value = "/payment", method = RequestMethod.DELETE)
    public void deleteAllPayment(){
        this.service.deleteAll();
    }

}
