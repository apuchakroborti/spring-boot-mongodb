package com.apu.mongodb.springbootmongodb.services.impls;

import com.apu.mongodb.springbootmongodb.dao.ProductDao;
import com.apu.mongodb.springbootmongodb.model.Product;
import com.apu.mongodb.springbootmongodb.repository.ProductRepository;
import com.apu.mongodb.springbootmongodb.services.ProductService;
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
    public Flux<Product> loadAllProductsStream() {
        long start = System.currentTimeMillis();
        Flux<Product> customers = dao.getProductsStream();
        long end = System.currentTimeMillis();
        System.out.println("Total execution time : " + (end - start));
        return customers;
    }
    @Override
    public Mono<Product> saveProduct(Product product){
        return productRepository.save(product);

    }
    @Override
    public Mono<Product> updateProductById(Long id, Product product1){
        return productRepository.findById(id)
                .doOnNext(e->e.setId(id));
        /*Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            if(product1.getName()!=null){
                product.setName(product1.getName());
            }
             productRepository.save(product);
            return Mono.just(product);
        }
        return Mono.just(null);*/
    }

    @Override
    public Mono<Product> getProductById(Long id) {
        return productRepository.findById(id)
                .doOnNext(e->e.setId(id));
        /*Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            return Mono.just(optionalProduct.get());
        }
        return Mono.just(null);*/
    }

    @Override
    public Mono<Boolean> deleteProductById(Long id){
        productRepository.deleteById(id);

        return Mono.just(true);
    }
}
