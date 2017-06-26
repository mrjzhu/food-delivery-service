package com.jz.fooddeliverypayment.service.Impl;

import com.jz.fooddeliverypayment.domain.Payment;
import com.jz.fooddeliverypayment.domain.PaymentRepository;
import com.jz.fooddeliverypayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vagrant on 6/25/17.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository repository;

    @Override
    public List<Payment> findALl() {
        return this.repository.findAllBy();
    }

    @Override
    public void deleteAll() {
        this.repository.deleteAllBy();
    }

    @Override
    public void savePayment(Payment payment) {
        this.repository.save(payment);
    }


}
