package com.apu.mongodb.springbootmongodb.repository;

import com.apu.mongodb.springbootmongodb.model.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface WalletRepository extends ReactiveMongoRepository<Wallet, Long> {
}
