package com.apu.mongodb.springbootmongodb.controllers;

import com.apu.mongodb.springbootmongodb.model.Wallet;
import com.apu.mongodb.springbootmongodb.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    @Autowired
    private WalletService service;


    @GetMapping
    public Flux<Wallet> getAllWallets() {
        return service.getAllWallets();
    }

    @GetMapping(value = "/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Wallet> getAllWalletsStream() {
        return service.getAllWallets();
    }

    @PostMapping
    public Mono<Wallet> addWallet(@RequestBody Wallet wallet){
        return service.saveWallet(wallet);
    }

    @GetMapping("/{id}")
    public Mono<Wallet> getWalletById(@PathVariable("id") Long id){
        return service.findWalletById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Boolean> deleteWalletById(@PathVariable("id") Long id){
        service.deleteWalletById(id);
        return Mono.just(true);
    }
}
