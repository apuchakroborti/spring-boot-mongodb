package com.apu.mongodb.springbootmongodb.services.impls;

import com.apu.mongodb.springbootmongodb.dao.CustomerDao;
import com.apu.mongodb.springbootmongodb.dto.CustomerDto;
import com.apu.mongodb.springbootmongodb.model.Customer;
import com.apu.mongodb.springbootmongodb.repository.CustomerRepository;
import com.apu.mongodb.springbootmongodb.sequence_generator.ISequenceGeneratorService;
import com.apu.mongodb.springbootmongodb.services.CustomerService;
import com.apu.mongodb.springbootmongodb.services.WalletService;
import com.apu.mongodb.springbootmongodb.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
@Slf4j
public class CustomerServiceImpls implements CustomerService {
    private final CustomerDao dao;
    private final CustomerRepository customerRepository;
    private final WalletService walletService;
    private final ISequenceGeneratorService iSequenceGeneratorService;


    @Autowired
    CustomerServiceImpls(CustomerDao dao,
                         CustomerRepository customerRepository,
                         WalletService walletService,
                         ISequenceGeneratorService iSequenceGeneratorService){
        this.dao = dao;
        this.customerRepository = customerRepository;
        this.walletService = walletService;
        this.iSequenceGeneratorService = iSequenceGeneratorService;
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
    public Flux<CustomerDto> loadAllCustomersStream() {
        return customerRepository.findAll().map(Utils::entityToDtoCustomer);
    }

    @Override
    public Mono<CustomerDto> saveCustomer(Mono<CustomerDto> customerDtoMono) throws Exception{
        try {
            customerDtoMono = customerDtoMono.map(Utils::dtoToEntityCustomer)
                    .flatMap(customerRepository::insert)
                    .map(Utils::entityToDtoCustomer);

            //TODO need o create wallet while adding every customer
//            walletService.saveWallet(Mono.just(new WalletDto(null, null, "BDT", 100, true)));
        return customerDtoMono;
        }catch (Exception e){
            log.error(e.getMessage());
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public Mono<CustomerDto> updateCustomerById(Long id, Mono<CustomerDto> customerDtoMono){
        return customerRepository.findById(id)
                .flatMap(customer->customerDtoMono.map(Utils::dtoToEntityCustomer)
                        .doOnNext(e->e.setId(id)))
                .flatMap(customerRepository::save)
                .map(Utils::entityToDtoCustomer);
    }


    @Override
    public Mono<CustomerDto> findCustomerById(Long id){
        return customerRepository.findById(id)
                .map(Utils::entityToDtoCustomer);
    }
    @Override
    public Mono<Void> deleteCustomerById(Long id){
        return customerRepository.deleteById(id);
    }
}
