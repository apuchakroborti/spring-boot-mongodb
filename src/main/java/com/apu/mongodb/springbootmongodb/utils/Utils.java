package com.apu.mongodb.springbootmongodb.utils;

import com.apu.mongodb.springbootmongodb.dto.CustomerDto;
import com.apu.mongodb.springbootmongodb.dto.ProductDto;
import com.apu.mongodb.springbootmongodb.model.Customer;
import com.apu.mongodb.springbootmongodb.model.Product;
import org.springframework.beans.BeanUtils;

public class Utils {
    public static ProductDto entityToDtoP(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public static Product dtoToEntityP(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }

    public static CustomerDto entityToDtoC(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }

    public static Customer dtoToEntityC(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        return customer;
    }
}
