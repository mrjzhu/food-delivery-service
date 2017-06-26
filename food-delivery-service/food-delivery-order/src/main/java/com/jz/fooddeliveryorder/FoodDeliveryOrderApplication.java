package com.jz.fooddeliveryorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class FoodDeliveryOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodDeliveryOrderApplication.class, args);
	}
}
