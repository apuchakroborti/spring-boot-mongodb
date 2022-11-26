package com.apu.mongodb.springbootmongodb.model;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Transient;

@Getter
@Setter
@ToString
@Document(collection = "wallets")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Wallet {
    @Transient
    public static final String SEQUENCE_NAME = "wallet_sequence";

    @Id
    private Long id;
    private Long customerId;
    private String currency;
    private Integer balance;
    private Boolean status;
}
