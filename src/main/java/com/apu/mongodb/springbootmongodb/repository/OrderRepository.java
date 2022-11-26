package com.apu.mongodb.springbootmongodb.repository;

import com.apu.mongodb.springbootmongodb.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface OrderRepository extends ReactiveMongoRepository<Order, Long> {
}
