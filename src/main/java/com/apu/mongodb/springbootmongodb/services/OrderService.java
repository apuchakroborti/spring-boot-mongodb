package com.apu.mongodb.springbootmongodb.services;

import com.apu.mongodb.springbootmongodb.dto.OrderDto;
import com.apu.mongodb.springbootmongodb.model.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface OrderService {
    List<Order> loadAllOrders();
    Flux<Order> loadAllOrdersStream();
    Mono<OrderDto> saveOrder(Mono<OrderDto> orderDtoMono);
    Mono<OrderDto> updateOrderById(Long id, Mono<OrderDto> orderDtoMono);
    Mono<OrderDto> findOrderById(Long id);
    Mono<Void> deleteOrderById(Long id);
}
