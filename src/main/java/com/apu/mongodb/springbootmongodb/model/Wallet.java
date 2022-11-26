package com.apu.mongodb.springbootmongodb.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "wallets")
public class Wallet {
    @Id
    private Long id;
    private Long customerId;
    private String currency;
    private Integer balance;
    private Boolean status;
}
