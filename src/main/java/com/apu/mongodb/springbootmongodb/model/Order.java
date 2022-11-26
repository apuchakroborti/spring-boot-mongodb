package com.apu.mongodb.springbootmongodb.model;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Getter
@Setter
@ToString
@Document(collection = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Order {
    @Transient
    public static final String SEQUENCE_NAME = "order-id";

    @Id
    private Long id;
    private Map<Product, Integer> productWithQuantity;
    private Integer totalAmount;
    private Boolean paymentStatus;;
    private String shippingAddress;
}
