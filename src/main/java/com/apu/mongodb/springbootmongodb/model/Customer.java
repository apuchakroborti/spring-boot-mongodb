package com.apu.mongodb.springbootmongodb.model;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@Setter
@ToString
@Document(collection = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Customer {
    @Transient
    public static final String SEQUENCE_NAME = "customer_sequence";


    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private String phone;
}
