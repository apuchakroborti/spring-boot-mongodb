package com.apu.mongodb.springbootmongodb.services;

import com.apu.mongodb.springbootmongodb.dto.CustomerDto;
import com.apu.mongodb.springbootmongodb.model.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CustomerService {
    List<Customer> loadAllCustomers();
    Flux<CustomerDto> loadAllCustomersStream();
    Mono<CustomerDto> saveCustomer(Mono<CustomerDto> customerDtoMono) throws Exception;
    Mono<CustomerDto> updateCustomerById(Long id, Mono<CustomerDto> customerDto);
    Mono<Void> deleteCustomerById(Long id);
    Mono<CustomerDto> findCustomerById(Long id);
}
