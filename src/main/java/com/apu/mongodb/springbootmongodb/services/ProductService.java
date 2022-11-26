package com.apu.mongodb.springbootmongodb.services;

import com.apu.mongodb.springbootmongodb.dto.ProductDto;
import com.apu.mongodb.springbootmongodb.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ProductService {
    List<Product> loadAllProducts();
    Flux<Product> loadAllProductsStream();
    Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono);
    Mono<ProductDto> updateProductById(Long id, Mono<ProductDto> productDtoMono);
    Mono<ProductDto> getProductById(Long id);
    Mono<Void> deleteProductById(Long id);
}
