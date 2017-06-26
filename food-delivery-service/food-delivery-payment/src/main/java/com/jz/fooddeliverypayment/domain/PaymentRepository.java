package com.jz.fooddeliverypayment.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vagrant on 6/25/17.
 */
@RepositoryRestResource(path = "paymenInfo")
public interface PaymentRepository extends JpaRepository<Payment,Long> {
    @RestResource(path = "payment")
    List<Payment> findAllBy();
    @RestResource(path = "delete")
    @Transactional
    void deleteAllBy();
}
