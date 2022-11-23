package com.apu.mongodb.springbootmongodb.repository;

import com.apu.mongodb.springbootmongodb.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, Integer> {
    List<Author> findAllByAuthorName(String authorName);
}
