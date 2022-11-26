package com.apu.mongodb.springbootmongodb.controllers;

import com.apu.mongodb.springbootmongodb.model.Order;
import com.apu.mongodb.springbootmongodb.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;


    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.loadAllOrders();
    }

    @GetMapping(value = "/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Order> getAllOrdersStream() {
        return orderService.loadAllOrdersStream();
    }


    @PostMapping
    public Mono<Order> addOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }


    @GetMapping("/{id}")
    public Mono<Order> getOrderById(@PathVariable("id") Long id){
        return orderService.findOrderById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Boolean> deleteOrderById(@PathVariable("id") Long id){
        orderService.deleteOrderById(id);
        return Mono.just(true);
    }
}
