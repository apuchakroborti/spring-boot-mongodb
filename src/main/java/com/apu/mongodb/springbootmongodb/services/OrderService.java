package com.apu.mongodb.springbootmongodb.services;

import com.apu.mongodb.springbootmongodb.model.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface OrderService {
    List<Order> loadAllOrders();
    Flux<Order> loadAllOrdersStream();
    Mono<Order> saveOrder(Order order);
    Mono<Order> updateOrderById(Long id, Order customer);
    Mono<Order> findOrderById(Long id);
    Mono<Boolean> deleteOrderById(Long id);
}
