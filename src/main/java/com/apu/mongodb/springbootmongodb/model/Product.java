package com.apu.mongodb.springbootmongodb.model;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Getter
@Setter
@ToString
@Document(collection = "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Product {

    @Transient
    public static final String SEQUENCE_NAME = "product-id";

    @Id
    private Long id;
    private String name;
    private Integer price;
    private List<String> imageUrls;
    private String category;
    private Integer copyAvailable;
    private String vendor;
}
