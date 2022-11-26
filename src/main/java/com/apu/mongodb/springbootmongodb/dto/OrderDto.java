package com.apu.mongodb.springbootmongodb.dto;

import com.apu.mongodb.springbootmongodb.model.Product;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private Map<Product, Integer> productWithQuantity;
    private Integer totalAmount;
    private Boolean paymentStatus;;
    private String shippingAddress;
}
