package com.apu.mongodb.springbootmongodb.services;

import com.apu.mongodb.springbootmongodb.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ProductService {
    List<Product> loadAllProducts();
    Flux<Product> loadAllProductsStream();
    Mono<Product> saveProduct(Product product);
    Mono<Product> updateProductById(Long id, Product product);
    Mono<Product> getProductById(Long id);
    Mono<Boolean> deleteProductById(Long id);
}
