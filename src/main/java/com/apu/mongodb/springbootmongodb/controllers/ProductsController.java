package com.apu.mongodb.springbootmongodb.controllers;

import com.apu.mongodb.springbootmongodb.model.Product;
import com.apu.mongodb.springbootmongodb.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @Autowired
    private ProductService productService;


    @GetMapping
    public List<Product> getAllProducts() {
        return productService.loadAllProducts();
    }

    @GetMapping(value = "/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> getAllProductsStream() {
        return productService.loadAllProductsStream();
    }


    @PostMapping
    public Mono<Product> addProduct(@RequestBody Product product){
        Mono<Product>  productMono = productService.saveProduct(product);
        return productMono;
    }


    @GetMapping("/{id}")
    public Mono<Product> getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Boolean> deleteProductById(@PathVariable("id") Long id){
        productService.deleteProductById(id);

        return Mono.just(true);
    }
}
