#Food Delivery Service
#### by Jian ZHu

##Service Function
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
     
## API design:

### food-delivery-restaurant service
1.upload(): (POST)
   * upload the initial restaurant and menu data,

2 delete ():(DELETE)
   * Delete all the data.
   
3 findRestaurant() (GET)
   * Query the restaurant by name
   
### food-delivery-order service

1.upload(): (POST)
   * upload the initial Order to simulate the process,

2 delete() :(DELETE)
   * Delete all the orders.
   
3 findAll() (GET)
   * return all the orders.
   

### food-delivery-payment service
1.save(): (POST)
   * user make a payment, database store the payment history,

2 delete() :(DELETE)
   * Delete all the history(In real world, better not).
   
3 findRestaurant() (GET)
   * Query the payment history

### Sequence to start these API
   * upload restaurant and menu data to DB,
   
   * user start to make a order
   
   * user make a payment, get the payment message.
   
   
### Test Data.

#### food-delivery-restaurant service
```
[
 {
 "Name": "Dragon",
 "Description": "RESTAURANT 1",
 "menuItems": [{
 "itemName": "meat",
 "itemPrice": 10.00
 },
 {
 "itemName": "fruit",
 "itemPrice": 15.00
 }]
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
 }]
 }
]
```

#### food-delivery-order service

```
[
 {
	"deliveryAddress": "2518S Street",
	"items": 
	[
		{
		"item":{
			"itemName": "meat",
			"itemPrice": 10.00
		},
		 "quantity": 2,
		 "note":"spicy please"
		},
		{
		"item":{
			"itemName": "fruit",
			"itemPrice": 15.00
		},
		 "quantity": 2,
		 "note":"more please"
		 }
	]
 }
]

```
#### food-delivery-payment service

```
{
    "orderId": "1",
    "cardNo": "3453456789098",
    "expirationDate": "May 1, 2017",
    "securityCode": "322"
  },
  {
    "order_id": "2",
    "cardNo": "4312454454545454",
    "expirationDate": "May 5, 2015",
    "securityCode": "566"
  },
```

## PS
* ALl the testcase used for test, needed to improve in future.
* Will add UI in the future.