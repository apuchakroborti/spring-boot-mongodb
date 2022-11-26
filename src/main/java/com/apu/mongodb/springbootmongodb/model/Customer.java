package com.apu.mongodb.springbootmongodb.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "customers")
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
}
