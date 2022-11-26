package com.apu.mongodb.springbootmongodb.services.impls;

import com.apu.mongodb.springbootmongodb.dao.CustomerDao;
import com.apu.mongodb.springbootmongodb.dto.CustomerDto;
import com.apu.mongodb.springbootmongodb.model.Customer;
import com.apu.mongodb.springbootmongodb.repository.CustomerRepository;
import com.apu.mongodb.springbootmongodb.services.CustomerService;
import com.apu.mongodb.springbootmongodb.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
public class CustomerServiceImpls implements CustomerService {
    private final CustomerDao dao;
    private final CustomerRepository customerRepository;


    @Autowired
    CustomerServiceImpls(CustomerDao dao,
                         CustomerRepository customerRepository){
        this.dao = dao;
        this.customerRepository = customerRepository;
    }


    @Override
    public List<Customer> loadAllCustomers() {
        long start = System.currentTimeMillis();
        List<Customer> customers = dao.getCustomers();
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : " + (end - start));
        return customers;
    }


    @Override
    public Flux<Customer> loadAllCustomersStream() {
        long start = System.currentTimeMillis();
        Flux<Customer> customers = customerRepository.findAll();
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : " + (end - start));
        return customers.delayElements(Duration.ofSeconds(1));
    }

    @Override
    public Mono<Customer> saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }
    @Override
    public Mono<CustomerDto> updateCustomerById(Long id, Mono<CustomerDto> customerDtoMono){
        return customerRepository.findById(id)
                .flatMap(customer->customerDtoMono.map(Utils::dtoToEntityC)
                        .doOnNext(e->e.setId(id)))
                .flatMap(customerRepository::save)
                .map(Utils::entityToDtoC);
    }


    @Override
    public Mono<Void> deleteCustomerById(Long id){
        return customerRepository.deleteById(id);
    }
    @Override
    public Mono<CustomerDto> findCustomerById(Long id){
        return customerRepository.findById(id)
                .map(Utils::entityToDtoC);
    }
    private static void sleepExecution(int i){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
