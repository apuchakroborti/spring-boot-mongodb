package com.apu.mongodb.springbootmongodb.services;

import com.apu.mongodb.springbootmongodb.dto.OrderDto;
import com.apu.mongodb.springbootmongodb.dto.WalletDto;
import com.apu.mongodb.springbootmongodb.model.Wallet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface WalletService {
    Flux<Wallet> getAllWallets();
    Mono<WalletDto> saveWallet(Mono<WalletDto> walletDtoMono) throws Exception;
    Mono<WalletDto> updateWalletById(Long id, Mono<WalletDto> walletDtoMono);
    Mono<WalletDto> findWalletById(Long id);
    Mono<Void> deleteWalletById(Long id);
}
