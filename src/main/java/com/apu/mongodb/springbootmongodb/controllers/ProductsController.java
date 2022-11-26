package com.apu.mongodb.springbootmongodb.controllers;

import com.apu.mongodb.springbootmongodb.dto.ProductDto;
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

    @GetMapping(value = "/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ProductDto> getAllProductsStream() {
        return productService.loadAllProductsStream();
    }


    @PostMapping
    public Mono<ProductDto> addProduct(@RequestBody Mono<ProductDto> productDtoMono){
        return productService.saveProduct(productDtoMono);
    }

    @PutMapping("/{id}")
    public Mono<ProductDto> updateProductById(@PathVariable("id") Long id, @RequestBody Mono<ProductDto> productDtoMono){
        return productService.updateProductById(id, productDtoMono);
    }

    @GetMapping("/{id}")
    public Mono<ProductDto> getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProductById(@PathVariable("id") Long id){
        return productService.deleteProductById(id);
    }
}
