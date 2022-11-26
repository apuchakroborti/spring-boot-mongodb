package com.apu.mongodb.springbootmongodb.dao;

import com.apu.mongodb.springbootmongodb.model.Order;
import com.apu.mongodb.springbootmongodb.model.Product;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class OrderDao {
    private static void sleepExecution(int i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Order> getOrders()  {
        Map<Product, Integer> map = new HashMap<>();
        Product product = new Product(1L, "", 100, Collections.emptyList(), "", 0, "");
        map.put(product, 1);

        return IntStream.rangeClosed(1, 10)
                .peek(OrderDao::sleepExecution)
                .peek(i -> System.out.println("processing count : " + i))
                .mapToObj(i -> new Order(new Long(i), map,100, true, "Mirpur, Dhaka"))
                .collect(Collectors.toList());
    }


    public Flux<Order> getOrdersStream()  {
        Map<Product, Integer> map = new HashMap<>();
        Product product = new Product(1L, "", 100, Collections.emptyList(), "", 0, "");
        map.put(product, 1);
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("processing count in stream flow : " + i))
                .map(i -> new Order(new Long(i), map,100, true, "Mirpur, Dhaka"));
    }


    public Flux<Order> getOrdersList()  {
        Map<Product, Integer> map = new HashMap<>();
        Product product = new Product(1L, "", 100, Collections.emptyList(), "", 0, "");
        map.put(product, 1);

        return Flux.range(1,50)
                .doOnNext(i -> System.out.println("processing count in stream flow : " + i))
                .map(i -> new Order(new Long(i), map,100, true, "Mirpur, Dhaka"));
    }
}
