# Food Delivery Service
#### by Jian ZHu

## Service Function
1. search restaurant by restaurant name,
2. choose different menu Items, quantity and notes,
3. user can place a order and make a payment.



## Sub-service
#### use mysql for relatioal database and MongoDB for NOSQL database


1. food-delivery-restaurant (MongoDB)
     * query restaurant and its menu;
2. food-delivery-order(MongoDB)
     * choose different items and place a order
3. food-delivery-payment(Mysql)
     * make a payment. 
     
## RESTAPI design:

### food-delivery-restaurant service
1.upload(): (POST)
   ```
   "/RestaurantInfo"
   ```
   * upload the initial restaurant and menu data,

2 delete ():(DELETE)
  ```
   "/RestaurantInfo"
   ```
   * Delete all the data.
   
3 findRestaurant() (GET)
   ```
   "/RestaurantInfo/{name}"
   ```
   * Query the restaurant by name
   
4 findItems() (GET)
   ```
   "/RestaurantInfo/{name}/Items"
   ```
   * get menuItems by Restaurant name
   
   
### food-delivery-order service

1.upload(): (POST)
```
/OrderService
```
   * CREATE ORDERS;

2 delete() :(DELETE)
```
/OrderService
```
   * DELETE ALL ORDERS
   
3 deleteById() : (DELETE)
```
/OrderService/{orderId}
```
* DELETE ORDERS BY ID

4 findAll() (GET)
```
/OrderService
```
   * RETURN ALL THE ORDERS


### food-delivery-payment service
1.save(): (POST)
```
/Payment
```
   * user make a payment, database store the payment history,

2 delete() :(DELETE)
```
/Payment
```
   * Delete all the history(In real world, better not).
   
3 findALLPaymentt() (GET)
```
/Payment
```
   * Query the payment history

### notes:
Above Rest APIs return the result with JSON FORMAT, 
We can use POSTMAN to send request and Check the response;

# ------------------------------------------------------

## In order to demonstrate the application flow, use UI to Integrated backend service.
## Tools: Thymeleaf
First, we need to add dependency on all services.:
```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
```

### Before start application
start MongoDB for restaurant and order service, and start MYSQL for payment service

```
cd food-delivery-service/food-delivery-order
```

```
docker-compose up
```
```
cd food-delivery-service/food-delivery-payment
```

```
docker-compose up
```


### Sequence to start these APPLICATION
1.start three services
```
   cd food-delivery-service/food-delivery-order
   mvn clean install
   cd target
   java -jar food-delivery-order-0.0.1-SNAPSHOT.jar 
```

```
   cd food-delivery-service/food-delivery-payment
   mvn clean install
   cd target
   java -jar food-delivery-payment-0.0.1-SNAPSHOT.jar 
```

```
   cd food-delivery-service/food-delivery-resturant
   mvn clean install
   cd target
   java -jar food-delivery-resturant-0.0.1-SNAPSHOT.jar 
```
   2.I assume that we have already have the initial restaurant information and menus;(post the data with post man) 
   url:localhost:9004/RestaurantInfo
   ```
   [
    {
    "Name": "Dragon",
    "Description": "RESTAURANT 1",
    "menuItems": [
    	{
   		"itemName": "meat",
   		"itemPrice": 10.00
   	},
   	{
   		"itemName": "chocolate",
   		"itemPrice": 13.00
   	},
   	{
   		"itemName": "salad",
   		"itemPrice": 10.00
   	},
   	{
   		"itemName": "fruit",
   		"itemPrice": 15.00
   	},
   	{
   		"itemName": "chicken",
   		"itemPrice": 17.00
   	}
   	]
    },
     {
    "Name": "Ball",
    "Description": "RESTAURANT 2",
    "menuItems": [{
   		"itemName": "barbeque",
   		"itemPrice": 30.00
   	},
   	{
   		"itemName": "Duck",
   		"itemPrice": 12.00
   	},
   	{
   		"itemName": "fruit",
   		"itemPrice": 19.00
   	},
   	{
   		"itemName": "fish",
   		"itemPrice": 5.00
   	},
   	{
   		"itemName": "wing",
   		"itemPrice": 12.00
   	},
   	{
   		"itemName": "tender",
   		"itemPrice": 15.00
   	}
   	]
    }
   ]

   ```
   
   
   2.Login url: http://localhost:9005, which is the mainPage the the whole application.
   * step 1, search restaurant by name (default name ="Ball")
   * step 2, add items to shopping cart, choose quantity and add notes for restriction
   * step 3, enter the delivery address then click Place order to create order.
   * step 4, choose a order to pay or delete the order.
   * Step 5, input payment information to finish pay.
   * step 6, if payment finishd, start to delivery.
   
   
   
   


## PS
 Because UI added, add a UIcontroller class to control the message transaction between different service.
  