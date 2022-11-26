package com.apu.mongodb.springbootmongodb.services;

import com.apu.mongodb.springbootmongodb.model.Wallet;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface WalletService {
    Flux<Wallet> getAllWallets();
    Mono<Wallet> saveWallet(Wallet wallet);
    Mono<Wallet> updateWalletById(Long id, Wallet wallet);
    Mono<Boolean> deleteWalletById(Long id);
    Mono<Wallet> findWalletById(Long id);
}
