package com.apu.mongodb.springbootmongodb.controllers;

import com.apu.mongodb.springbootmongodb.dto.WalletDto;
import com.apu.mongodb.springbootmongodb.model.Wallet;
import com.apu.mongodb.springbootmongodb.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    @Autowired
    private WalletService walletService;


    @GetMapping
    public Flux<Wallet> getAllWallets() {
        return walletService.getAllWallets();
    }

    @GetMapping(value = "/stream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Wallet> getAllWalletsStream() {
        return walletService.getAllWallets();
    }

    @PostMapping
    public Mono<WalletDto> addWallet(@RequestBody Mono<WalletDto> walletDtoMono) throws Exception{
        return walletService.saveWallet(walletDtoMono);
    }

    @PostMapping("/{id}")
    public Mono<WalletDto> updateWalletById(@PathVariable("id") Long id, @RequestBody Mono<WalletDto> walletDtoMono){
        return walletService.updateWalletById(id, walletDtoMono);
    }

    @GetMapping("/{id}")
    public Mono<WalletDto> getWalletById(@PathVariable("id") Long id){
        return walletService.findWalletById(id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteWalletById(@PathVariable("id") Long id){
        return walletService.deleteWalletById(id);
    }
}
