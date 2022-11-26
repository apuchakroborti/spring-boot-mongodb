package com.apu.mongodb.springbootmongodb.services.impls;

import com.apu.mongodb.springbootmongodb.dao.OrderDao;
import com.apu.mongodb.springbootmongodb.dto.OrderDto;
import com.apu.mongodb.springbootmongodb.model.Order;
import com.apu.mongodb.springbootmongodb.repository.OrderRepository;
import com.apu.mongodb.springbootmongodb.services.OrderService;
import com.apu.mongodb.springbootmongodb.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class OrderServiceImpls implements OrderService {

    private final OrderDao dao;
    private final OrderRepository orderRepository;

    @Autowired
    OrderServiceImpls(OrderDao dao,
                      OrderRepository orderRepository){
        this.dao = dao;
        this.orderRepository = orderRepository;
    }


    @Override
    public List<Order> loadAllOrders() {
        long start = System.currentTimeMillis();
        List<Order> orders = dao.getOrders();
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : " + (end - start));
        return orders;
    }


    @Override
    public Flux<Order> loadAllOrdersStream() {
        long start = System.currentTimeMillis();
        Flux<Order> ordersStream = dao.getOrdersStream();
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : " + (end - start));
        return ordersStream;
    }
    @Override
    public Mono<OrderDto> saveOrder(Mono<OrderDto> orderDtoMono){
        return orderDtoMono.map(Utils::dtoToEntityOrder)
                .flatMap(orderRepository::insert)
                .map(Utils::entityToDtoOrder);

    }
    @Override
    public Mono<OrderDto> updateOrderById(Long id, Mono<OrderDto> orderDtoMono){
        return orderRepository.findById(id)
                .flatMap(order -> orderDtoMono.map(Utils::dtoToEntityOrder)
                    .doOnNext(o -> o.setId(id)))
                .map(Utils::entityToDtoOrder);

    }

    @Override
    public Mono<OrderDto> findOrderById(Long id){
        return orderRepository.findById(id)
                .map(Utils::entityToDtoOrder);
    }

    @Override
    public Mono<Void> deleteOrderById(Long id){
        return orderRepository.deleteById(id);
    }
}
