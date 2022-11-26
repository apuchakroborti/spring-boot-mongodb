package com.apu.mongodb.springbootmongodb.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Getter
@Setter
@ToString
@Document(collection = "products")
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private Long id;
    private String name;
    private Integer price;
    private List<String> imageUrls;
    private String category;
    private Integer copyAvailable;
    private String vendor;
}
