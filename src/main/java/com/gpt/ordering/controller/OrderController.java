package com.gpt.ordering.controller;

import com.gpt.ordering.model.Item;
import com.gpt.ordering.model.Order;
import com.gpt.ordering.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody List<Item> items) {
        // Calculate the total by summing the price of all items
        double total = items.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();

        // Create a new order
        Order order = new Order();
        order.setMessage("Your Order has been placed");
        order.setStatus("PLACED");
        order.setTotal(total);
        orderRepository.save(order);

        // Return the order
        return ResponseEntity.ok(order);
    }

    //return list of orders
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders() {
        // Calculate the total by summing the price of all items
        List<Order> orders = orderRepository.findAll();

        // Return the order
        return ResponseEntity.ok(orders);
    }
}