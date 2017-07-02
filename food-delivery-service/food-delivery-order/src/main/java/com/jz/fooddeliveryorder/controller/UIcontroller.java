package com.jz.fooddeliveryorder.controller;

import com.jz.fooddeliveryorder.domain.Item;
import com.jz.fooddeliveryorder.domain.ItemInfo;
import com.jz.fooddeliveryorder.domain.Order;
import com.jz.fooddeliveryorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * Created by vagrant on 7/1/17.
 */
@Controller
public class UIcontroller {
    @Autowired
    private OrderService service;

    @RequestMapping(value = "/Item",method = RequestMethod.GET)
    public String findItems(Model model,@RequestParam(value="name", required=false) String resturantName
                            ){
        String defaultRestaurant = "Ball";
        if(resturantName!=null&& !resturantName.equals("")){
            defaultRestaurant = resturantName;
        }
        model.addAttribute("Items",this.service.getItemsByRestaurantName(defaultRestaurant));
        model.addAttribute("cartItems",this.service.displayAllItemsSelected());
        model.addAttribute("Order",this.service.findAllOrders());
        return "Item";
    }

    @RequestMapping(value = "/Cart",method = RequestMethod.POST)
    public String cart(Model model,@RequestParam(value="name1", required=false) String itemName,
                       @RequestParam(value="price", required=false) String itemPrice,
                       @RequestParam(value="quantity", required=false) String quantity,
                       @RequestParam(value="note", required=false) String note){
        this.service.saveItems(new ItemInfo(itemName,Double.valueOf(itemPrice),Integer.valueOf(quantity),note));
        return "redirect:/Item";
    }

    @RequestMapping(value = "/Cart/Delete",method = RequestMethod.POST)
    public String emptyCart(Model model) {
        this.service.deleteAllItemsSelected();
        return "redirect:/Item";
    }

    @RequestMapping(value = "/Order/Delete",method = RequestMethod.POST)
    public String deleterOrder(Model model,@RequestParam(value="orderId", required=false) String orderId) {
        this.service.deleteById(orderId);
        return "redirect:/Item";
    }

    @RequestMapping(value = "/Order",method = RequestMethod.POST)
    public String Order(Model model,@RequestParam(value="address", required=false) String address
                       ){
        this.service.placeOrder(new Order(" ",this.service.displayAllItemsSelected()," ",address,Double.valueOf("1")));
        return "redirect:/Item";
    }

    @RequestMapping(value = "/")
    public String index(Model model){
        return "Item";
    }
}
