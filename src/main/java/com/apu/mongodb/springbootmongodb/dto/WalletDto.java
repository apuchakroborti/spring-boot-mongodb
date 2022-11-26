package com.apu.mongodb.springbootmongodb.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WalletDto {
    private Long id;
    private Long customerId;
    private String currency;
    private Integer balance;
    private Boolean status;
}
