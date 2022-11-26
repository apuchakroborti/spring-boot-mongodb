package com.apu.mongodb.springbootmongodb.utils;

import com.apu.mongodb.springbootmongodb.dto.CustomerDto;
import com.apu.mongodb.springbootmongodb.dto.OrderDto;
import com.apu.mongodb.springbootmongodb.dto.ProductDto;
import com.apu.mongodb.springbootmongodb.dto.WalletDto;
import com.apu.mongodb.springbootmongodb.model.Customer;
import com.apu.mongodb.springbootmongodb.model.Order;
import com.apu.mongodb.springbootmongodb.model.Product;
import com.apu.mongodb.springbootmongodb.model.Wallet;
import org.springframework.beans.BeanUtils;

public class Utils {
    public static ProductDto entityToDtoProduct(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    public static Product dtoToEntityProduct(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return product;
    }

    public static CustomerDto entityToDtoCustomer(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        return customerDto;
    }

    public static Customer dtoToEntityCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        return customer;
    }
    public static OrderDto entityToDtoOrder(Order order) {
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(order, orderDto);
        return orderDto;
    }

    public static Order dtoToEntityOrder(OrderDto orderDto) {
        Order order = new Order();
        BeanUtils.copyProperties(orderDto, order);
        return order;
    }
    public static WalletDto entityToDtoWallet(Wallet wallet) {
        WalletDto walletDto = new WalletDto();
        BeanUtils.copyProperties(wallet, walletDto);
        return walletDto;
    }

    public static Wallet dtoToEntityWallet(WalletDto walletDto) {
        Wallet wallet = new Wallet();
        BeanUtils.copyProperties(walletDto, wallet);
        return wallet;
    }
}
