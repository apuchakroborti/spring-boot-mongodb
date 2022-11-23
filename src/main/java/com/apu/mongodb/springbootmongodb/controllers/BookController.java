package com.apu.mongodb.springbootmongodb.controllers;

import com.apu.mongodb.springbootmongodb.model.Book;
import com.apu.mongodb.springbootmongodb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book){
        bookRepository.save(book);
        return "Added book with id: "+book.getId();
    }

    @GetMapping("/findAllBooks")
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    @GetMapping("/findAllBooks/{id}")
    public Optional<Book> getBookById(@PathVariable("id") Integer id){
        return bookRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);
        return "Book delete with id : "+id;
    }

    @GetMapping("/findAllBooksByName/{name}")
    public List<Book> getBooksByName(@PathVariable("name") String name){
        return bookRepository.findAllByBookName(name);
    }
}
