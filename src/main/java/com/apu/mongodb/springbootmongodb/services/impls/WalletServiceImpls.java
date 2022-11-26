package com.apu.mongodb.springbootmongodb.services.impls;

import com.apu.mongodb.springbootmongodb.dao.WalletDao;
import com.apu.mongodb.springbootmongodb.model.Wallet;
import com.apu.mongodb.springbootmongodb.repository.WalletRepository;
import com.apu.mongodb.springbootmongodb.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.List;

@Service
public class WalletServiceImpls implements WalletService {
    @Autowired
    private WalletDao dao;

    @Autowired
    private WalletRepository walletRepository;


    @Override
    public Flux<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    @Override
    public Mono<Wallet> saveWallet(Wallet wallet){
        return  walletRepository.save(wallet);

    }

    @Override
    public Mono<Wallet> updateWalletById(Long id, Wallet wallet){
        return walletRepository.findById(id)
                .doOnNext(wallet1 -> wallet1.setId(id));
        /*Optional<Wallet> optionalWallet = walletRepository.findById(id);
        if(optionalWallet.isPresent()){
            Wallet walletEO = new Wallet();

            if(wallet.getBalance()!=null){
                walletEO.setBalance(walletEO.getBalance() - wallet.getBalance());
            }
            walletRepository.save(walletEO);
            return Mono.just(walletEO);
        }
        return Mono.just(null);*/
    }

    @Override
    public Mono<Boolean> deleteWalletById(Long id){
        walletRepository.deleteById(id);

        return Mono.just(true);
    }

    @Override
    public Mono<Wallet> findWalletById(Long id) {
        return walletRepository.findById(id)
                .doOnNext(wallet1 -> wallet1.setId(id));
        /*Optional<Wallet> optionalWallet = walletRepository.findById(id);
        if(optionalWallet.isPresent()){
            return Mono.just(optionalWallet.get());
        }
        return Mono.just(null);*/
    }
}
