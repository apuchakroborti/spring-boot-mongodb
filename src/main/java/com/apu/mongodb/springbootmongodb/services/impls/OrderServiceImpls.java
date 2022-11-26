package com.apu.mongodb.springbootmongodb.services.impls;

import com.apu.mongodb.springbootmongodb.dao.OrderDao;
import com.apu.mongodb.springbootmongodb.model.Order;
import com.apu.mongodb.springbootmongodb.repository.OrderRepository;
import com.apu.mongodb.springbootmongodb.services.OrderService;
import com.apu.mongodb.springbootmongodb.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpls implements OrderService {
    @Autowired
    private OrderDao dao;

    @Autowired
    private OrderRepository orderRepository;


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
    public Mono<Order> saveOrder(Order order){
        return orderRepository.save(order);

    }
    @Override
    public Mono<Order> updateOrderById(Long id, Order order){
        return orderRepository.findById(id)
                        .doOnNext(e->e.setId(id));
        /*Optional<Order> optionalOrder = orderRepository.findById(id);
        if(optionalOrder.isPresent()){
            Order orderEO = optionalOrder.get();

            if(order.getShippingAddress()!=null){
                orderEO.setShippingAddress(order.getShippingAddress());
            }
            return Mono.just(orderEO);
        }
        return Mono.just(order);*/
    }
    @Override
    public Mono<Order> findOrderById(Long id){
        return orderRepository.findById(id)
                .doOnNext(e->e.setId(id));
        /*Optional<Order> optionalOrder = orderRepository.findById(id);
        if(optionalOrder.isPresent()){
            Order orderEO = optionalOrder.get();
            return Mono.just(orderEO);
        }
        return Mono.just(null);
*/    }

    @Override
    public Mono<Boolean> deleteOrderById(Long id){
        orderRepository.deleteById(id);

        return null;
    }
}
