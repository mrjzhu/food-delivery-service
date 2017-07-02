package com.jz.fooddeliverypayment.controller;

import com.jz.fooddeliverypayment.domain.Order;
import com.jz.fooddeliverypayment.domain.Payment;
import com.jz.fooddeliverypayment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 * Created by vagrant on 7/1/17.
 */
@Controller
public class UIController {
    @Autowired
    private PaymentService service;

    @RequestMapping(value = "/")
    public String index(Model model,@RequestParam(value="orderId", required=false) String orderId){
        RestTemplate restTemplate = new RestTemplate();
        String url =  "http://localhost:9005/OrderService/Orders/"+orderId;
        Order orders = restTemplate.getForObject(url,Order.class);
        model.addAttribute("Order",orders);
        return "Payment";
    }

    @RequestMapping(value = "/pay")
    public String pay(Model model,@RequestParam(value="orderId", required=false) String orderId,
                      @RequestParam(value="price", required=false) String price,
                      @RequestParam(value="CardNo", required=false) String cardNo,
                      @RequestParam(value="ExpirationDate", required=false) String Expire,
                      @RequestParam(value="SecurityCode", required=false) String SecurityCode){
        Payment payment = new Payment(orderId,cardNo,Double.valueOf(price),Expire,SecurityCode);
        model.addAttribute("paymentInfo",payment);

        double temp = Math.random()*(60 - 5);
        int time = (int)temp + 5;
        if(cardNo.length() < 16|| SecurityCode.length() != 3 || Expire.length() < 1){
            model.addAttribute("afterPayment","Payment Error");
        }
        else {
            model.addAttribute("afterPayment", "Payment Finished! Your food will be delivered in " + time + " Mins");
            this.service.savePayment(payment);

            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:9005/OrderService/" + orderId;
            restTemplate.delete(url);
        }
        return "paymentResult";
    }
}
