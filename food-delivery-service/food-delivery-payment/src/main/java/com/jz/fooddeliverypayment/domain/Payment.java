package com.jz.fooddeliverypayment.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by vagrant on 6/25/17.
 */
@Data
@Entity
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Table(name = "PAYMENT")
public class Payment {
    @Id
    @GeneratedValue
    private Long paymentId;

    private String orderId;

    private Date date;


    private String cardNo;
    private String expirationDate;
    private String securityCode;

    public Payment(){};
    @JsonCreator
    public Payment(@JsonProperty("paymentId") Long paymentId,
                   @JsonProperty("orderId") String orderId,
                   @JsonProperty("cardNo") String cardNumber,
//                   @JsonProperty("date") Date date,
                   @JsonProperty("expirationDate") String expirationDate,
                   @JsonProperty("securityCode") String securityCode) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.date = new Date();
        this.cardNo = cardNumber;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
    }
}
