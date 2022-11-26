package com.apu.mongodb.springbootmongodb.services.impls;

import com.apu.mongodb.springbootmongodb.dao.ProductDao;
import com.apu.mongodb.springbootmongodb.dto.ProductDto;
import com.apu.mongodb.springbootmongodb.model.Product;
import com.apu.mongodb.springbootmongodb.repository.ProductRepository;
import com.apu.mongodb.springbootmongodb.services.ProductService;
import com.apu.mongodb.springbootmongodb.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpls implements ProductService {

    @Autowired
    private ProductDao dao;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<Product> loadAllProducts() {
        long start = System.currentTimeMillis();
        List<Product> products = dao.getProducts();
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : " + (end - start));
        return products;
    }


    @Override
    public Flux<ProductDto> loadAllProductsStream() {
        long start = System.currentTimeMillis();
        Flux<ProductDto> products = productRepository.findAll()
                .map(Utils::entityToDtoProduct);
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : " + (end - start));
        return products;
    }
    @Override
    public Mono<ProductDto> saveProduct(Mono<ProductDto> productDtoMono){
        return productDtoMono.map(Utils::dtoToEntityProduct)
                .flatMap(productRepository::insert)
                .map(Utils::entityToDtoProduct);

    }
    @Override
    public Mono<ProductDto> updateProductById(Long id, Mono<ProductDto> productDtoMono){
        return productRepository.findById(id)
                .flatMap(order -> productDtoMono.map(Utils::dtoToEntityProduct)
                        .doOnNext(o -> o.setId(id)))
                .map(Utils::entityToDtoProduct);
    }

    @Override
    public Mono<ProductDto> getProductById(Long id) {
        return productRepository.findById(id)
                .map(Utils::entityToDtoProduct);
    }

    @Override
    public Mono<Void> deleteProductById(Long id){
        return productRepository.deleteById(id);
    }
}
