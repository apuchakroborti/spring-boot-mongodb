package com.apu.mongodb.springbootmongodb.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private Integer price;
    private List<String> imageUrls;
    private String category;
    private Integer copyAvailable;
    private String vendor;
}
