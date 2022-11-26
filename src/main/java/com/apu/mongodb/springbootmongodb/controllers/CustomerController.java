package com.apu.mongodb.springbootmongodb.controllers;

import com.apu.mongodb.springbootmongodb.dto.CustomerDto;
import com.apu.mongodb.springbootmongodb.model.Customer;
import com.apu.mongodb.springbootmongodb.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;


    @GetMapping
    public List<Customer> getAllCustomers() {
        return service.loadAllCustomers();
    }

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomersStream() {
        return service.loadAllCustomersStream();
    }


    @PostMapping
    public Mono<Customer> addCustomer(@RequestBody Customer customer){
        return service.saveCustomer(customer);
    }


    @GetMapping("/{id}")
    public Mono<CustomerDto> getCustomerById(@PathVariable("id") Long id){
        return service.findCustomerById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCustomerById(@PathVariable("id") Long id){
        return service.deleteCustomerById(id);
    }

    @PutMapping("/{id}")
    public Mono<CustomerDto> updateCustomerById(@PathVariable("id") Long id, @RequestBody Mono<CustomerDto> customerDto){
        return service.updateCustomerById(id, customerDto);
    }
}
