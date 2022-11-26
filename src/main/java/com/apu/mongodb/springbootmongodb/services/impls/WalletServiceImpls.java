package com.apu.mongodb.springbootmongodb.services.impls;

import com.apu.mongodb.springbootmongodb.dao.WalletDao;
import com.apu.mongodb.springbootmongodb.dto.CustomerDto;
import com.apu.mongodb.springbootmongodb.dto.WalletDto;
import com.apu.mongodb.springbootmongodb.model.Wallet;
import com.apu.mongodb.springbootmongodb.repository.WalletRepository;
import com.apu.mongodb.springbootmongodb.sequence_generator.ISequenceGeneratorService;
import com.apu.mongodb.springbootmongodb.services.WalletService;
import com.apu.mongodb.springbootmongodb.utils.Utils;
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

    @Autowired
    private ISequenceGeneratorService iSequenceGeneratorService;


    @Override
    public Flux<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    @Override
    public Mono<WalletDto> saveWallet(Mono<WalletDto> customerDtoMono) throws Exception{
        long walletIdSequence = iSequenceGeneratorService.generateSequence("wallet-id");

        return  customerDtoMono.map(Utils::dtoToEntityWallet)
                .flatMap(walletRepository::insert)
                .map(Utils::entityToDtoWallet);
    }
    @Override
    public Mono<WalletDto> updateWalletById(Long id, Mono<WalletDto> walletDtoMono){
        return walletRepository.findById(id)
                .flatMap(wallet->walletDtoMono.map(Utils::dtoToEntityWallet)
                        .doOnNext(e->e.setId(id)))
                .flatMap(walletRepository::save)
                .map(Utils::entityToDtoWallet);
    }


    @Override
    public Mono<WalletDto> findWalletById(Long id){
        return walletRepository.findById(id)
                .map(Utils::entityToDtoWallet);
    }
    @Override
    public Mono<Void> deleteWalletById(Long id){
        return walletRepository.deleteById(id);
    }
}
