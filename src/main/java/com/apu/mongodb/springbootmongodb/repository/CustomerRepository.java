package com.apu.mongodb.springbootmongodb.repository;

import com.apu.mongodb.springbootmongodb.model.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends ReactiveMongoRepository<Customer, Long> {

}
