package com.apu.mongodb.springbootmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Getter
@Setter
@ToString
@Document(collection = "orders")
@AllArgsConstructor
public class Order {
    @Id
    private Long id;
    private Map<Product, Integer> productWithQuantity;
    private Integer totalAmount;
    private Boolean paymentStatus;;
    private String shippingAddress;
}
