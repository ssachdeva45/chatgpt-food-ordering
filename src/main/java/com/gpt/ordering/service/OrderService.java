package com.gpt.ordering.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gpt.ordering.model.Order;
import com.gpt.ordering.repository.OrderRepository;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

//    @Transactional
//    @Scheduled(fixedDelay = 30000) // 5 minutes in milliseconds
//    public void updateOrders() {
//
//        // Fetch all orders with status "ACCEPTED" and update status to "DELIVERED"
//        orderRepository.findByStatus("ACCEPTED").forEach(order -> {
//            order.setStatus("DELIVERED");
//            orderRepository.save(order);
//        });
//
//        // Fetch all orders with status "PLACED" and update status to "ACCEPTED"
//        orderRepository.findByStatus("PLACED").forEach(order -> {
//            order.setStatus("ACCEPTED");
//            orderRepository.save(order);
//        });
//    }
}
