package com.apu.mongodb.springbootmongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication/*(scanBasePackages =
        {
                "com.apu.mongodb.springbootmongodb.model",
                "com.apu.mongodb.springbootmongodb.repository",
                "com.apu.mongodb.springbootmongodb.controllers",
                "com.apu.mongodb.springbootmongodb.dto"})*/
public class SpringBootMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbApplication.class, args);
    }

}
