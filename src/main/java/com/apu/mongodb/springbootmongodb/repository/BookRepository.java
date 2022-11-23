package com.apu.mongodb.springbootmongodb.repository;

import com.apu.mongodb.springbootmongodb.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
public interface BookRepository extends MongoRepository<Book, Integer> {

//    @Query("{'Book.bookName':?0}")
    List<Book> findAllByBookName(String bookName);
}
