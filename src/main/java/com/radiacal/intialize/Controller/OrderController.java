package com.radiacal.intialize.Controller;
import com.radiacal.intialize.Model.Order;
import com.radiacal.intialize.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
    @GetMapping("/allorders")
    public List<Order> getorders()
    {
        return orderService.getOrders();
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
       return String.format("Hello %s!", name);
    }
    @PostMapping("/addorder")
    public String addorder(@RequestBody Order order){
        return orderService.addOrder(order);
    }
    @GetMapping("/getorder/{id}")
    public Optional<Order> getorder(@PathVariable int id){
        return orderService.getOrderById(id);
    }
    @PutMapping("updateorder/{id}")
    public Optional<Order> updateorder(@PathVariable int id,@RequestBody Order order){
        return orderService.updateOrderById(id,order);
    }
    @GetMapping("deleteorder/{id}")
    public String deleteorder(@PathVariable int id){
        return orderService.deleteOderById(id);
    }
}
