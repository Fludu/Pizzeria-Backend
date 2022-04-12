package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping()
    public ResponseEntity<List<Order>> getFoodOrder() {
        List<Order> orderList = orderService.getAllOrders();
        return ResponseEntity.ok(orderList);
    }


    @PostMapping()
    public ResponseEntity<Order> saveFoodOrder(@RequestBody Order order) {
        Order createdOrder = orderService.saveOrder(order);
        return ResponseEntity.status(201).body(createdOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Order> deleteFoodOrder(@PathVariable Long id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PutMapping()
    public ResponseEntity<Order> updateFoodOrder(@RequestBody Order order) {
        orderService.updateOrder(order);
        return ResponseEntity.ok(order);
    }


}
