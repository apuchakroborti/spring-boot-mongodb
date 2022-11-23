package com.apu.mongodb.springbootmongodb.controllers;

import com.apu.mongodb.springbootmongodb.model.Author;
import com.apu.mongodb.springbootmongodb.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping("/addAuthor")
    public String saveAuthor(@RequestBody Author author){
        authorRepository.save(author);
        return "Added author with id: "+author.getId();
    }

    @GetMapping("/findAllAuthor")
    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    @GetMapping("/findAllAuthor/{id}")
    public Optional<Author> getAuthorById(@PathVariable("id") Integer id){
        return authorRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteAuthorById(@PathVariable("id") Integer id){
        authorRepository.deleteById(id);
        return "Author delete with id : "+id;
    }
    @GetMapping("/findAllAuthorByName/{name}")
    public List<Author> getAuthorsByName(@PathVariable("name") String name){
        return authorRepository.findAllByAuthorName(name);
    }
}
