package com.apu.mongodb.springbootmongodb;

import com.apu.mongodb.springbootmongodb.controllers.CustomerController;
import com.apu.mongodb.springbootmongodb.controllers.ProductsController;
import com.apu.mongodb.springbootmongodb.dto.CustomerDto;
import com.apu.mongodb.springbootmongodb.dto.ProductDto;
import com.apu.mongodb.springbootmongodb.services.CustomerService;
import com.apu.mongodb.springbootmongodb.services.ProductService;
import com.apu.mongodb.springbootmongodb.utils.Defs;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
//@WebFluxTest(CustomerController.class)
@WebFluxTest(ProductsController.class)
@Slf4j
class SpringBootMongodbApplicationTests {


    @Autowired
    private WebTestClient webTestClient;

    /*
    @MockBean
    private CustomerService customerService;
    @Test
    public void addCustomerTest() {
        try{
            Mono<CustomerDto> customerDtoMono = Mono.just(
                    new CustomerDto(1L, "first name", "last Name", "Mirpur", "apuchakroborti50@gmail.com",  "01768777777"));
            when(customerService.saveCustomer(customerDtoMono)).thenReturn(customerDtoMono);
            webTestClient.post().uri(Defs.CUSTOMERS)
                    .body(Mono.just(customerDtoMono), CustomerDto.class)
                    .exchange()
                    .expectStatus().isOk();//200

        }catch (Exception e){
            log.error("Exception occurred while adding new customer, message: {}", e.getMessage());
            e.printStackTrace();
        }
    }


    @Test
    public void getCustomersTest() {
        Flux<CustomerDto> customerDtoFlux = Flux.just(
                new CustomerDto(1L, "first name", "last Name", "Mirpur 1", "apuchakroborti@gmail.com",  "01768777777"),
                new CustomerDto(2L, "first name2", "last Name2", "Mirpur 2", "apuchakroborti2@gmail.com",  "01768777777"));

        when(customerService.loadAllCustomersStream()).thenReturn(customerDtoFlux);

        Flux<CustomerDto> responseBody = webTestClient.get().uri(Defs.CUSTOMER_GET_STREAM)
                .exchange()
                .expectStatus().isOk()
                .returnResult(CustomerDto.class)
                .getResponseBody();

        StepVerifier.create(responseBody)
                .expectSubscription()
                .expectNext(new CustomerDto(1L, "first name", "last Name", "Mirpur 1", "apuchakroborti@gmail.com",  "01768777777"))
                .expectNext(new CustomerDto(2L, "first name2", "last Name2", "Mirpur 2", "apuchakroborti2@gmail.com",  "01768777777"))
                .verifyComplete();
    }


    @Test
    public void getCustomerTest() {
        Mono<CustomerDto> productDtoMono = Mono.just(new CustomerDto(1L, "apu", "last Name", "Mirpur", "apuchakroborti@gmail.com",  "01768777777"));
        when(customerService.findCustomerById(any())).thenReturn(productDtoMono);

        Flux<CustomerDto> responseBody = webTestClient.get().uri(Defs.CUSTOMERS+"/1")
                .exchange()
                .expectStatus().isOk()
                .returnResult(CustomerDto.class)
                .getResponseBody();

        StepVerifier.create(responseBody)
                .expectSubscription()
                .expectNextMatches(p -> p.getFirstName().equals("apu"))
                .verifyComplete();
    }


    @Test
    public void updateCustomerTest() {
        Mono<CustomerDto> customerDtoMono = Mono.just(new CustomerDto(1L, "first name", "last Name", "Mirpur", "apuchakroborti@gmail.com",  "01768777777"));
        when(customerService.updateCustomerById(1L, customerDtoMono )).thenReturn(customerDtoMono);

        webTestClient.put().uri(Defs.CUSTOMERS+"/1")
                .body(Mono.just(customerDtoMono), CustomerDto.class)
                .exchange()
                .expectStatus().isOk();//200
    }

    @Test
    public void deleteCustomerTest() {
        given(customerService.deleteCustomerById(any())).willReturn(Mono.empty());
        webTestClient.delete().uri(Defs.CUSTOMERS+"/1")
                .exchange()
                .expectStatus().isOk();//200
    }*/

    @MockBean
    private ProductService productService;
    @Test
    public void addProductTest() {
        Mono<ProductDto> productDtoMono = Mono.just(new ProductDto(1L, "mobile", 1000, Collections.emptyList(), "", 100, "star tech"));
        when(productService.saveProduct(productDtoMono)).thenReturn(productDtoMono);

        webTestClient.post().uri(Defs.PRODUCTS)
                .body(Mono.just(productDtoMono), ProductDto.class)
                .exchange()
                .expectStatus().isOk();//200

    }


    @Test
    public void getProductsTest() {
        Flux<ProductDto> productDtoFlux = Flux.just(
                new ProductDto(1L, "TV", 100, Collections.emptyList(), "Electronic", 100, "ABC techs"),
                new ProductDto(2L, "TV", 100, Collections.emptyList(), "Electronic", 100, "ABC techs"));

//        when(productService.loadAllProductsStream()).thenReturn(productDtoFlux);
        when(productService.loadAllProductsStream()).thenReturn(productDtoFlux);


        Flux<ProductDto> responseBody = webTestClient.get().uri(Defs.PRODUCTS_GET_STREAM)
                .exchange()
                .expectStatus().isOk()
                .returnResult(ProductDto.class)
                .getResponseBody();

        StepVerifier.create(responseBody)
                .expectSubscription()
                .expectNext(new ProductDto(1L, "TV", 100, Collections.emptyList(), "Electronic", 100, "ABC techs"))
                .expectNext(new ProductDto(2L, "TV", 100, Collections.emptyList(), "Electronic", 100, "ABC techs"))
                .verifyComplete();

    }


    @Test
    public void getProductByIdTestTest() {
        Mono<ProductDto> productDtoMono = Mono.just(
                new ProductDto(1L, "TV", 100, Collections.emptyList(), "Electronic", 100, "ABC techs"));
        when(productService.getProductById(any())).thenReturn(productDtoMono);

        Flux<ProductDto> responseBody = webTestClient.get().uri(Defs.PRODUCTS+"/1")
                .exchange()
                .expectStatus().isOk()
                .returnResult(ProductDto.class)
                .getResponseBody();

        StepVerifier.create(responseBody)
                .expectSubscription()
                .expectNextMatches(p -> p.getName().equals("mobile"))
                .verifyComplete();
    }


    @Test
    public void updateProductTest() {
        Mono<ProductDto> productDtoMono = Mono.just(
                new ProductDto(1L, "TV", 100, Collections.emptyList(), "Electronic", 100, "ABC techs"));
        when(productService.updateProductById(1L, productDtoMono)).thenReturn(productDtoMono);

        webTestClient.put().uri(Defs.PRODUCTS+"/1")
                .body(Mono.just(productDtoMono), ProductDto.class)
                .exchange()
                .expectStatus().isOk();//200
    }

    @Test
    public void deleteProductTest() {
        given(productService.deleteProductById(any())).willReturn(Mono.empty());
        webTestClient.delete().uri(Defs.PRODUCTS+"/1")
                .exchange()
                .expectStatus().isOk();//200
    }

}