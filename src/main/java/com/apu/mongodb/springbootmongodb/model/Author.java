package com.apu.mongodb.springbootmongodb.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString
@Document(collection = "author")
public class Author {
    @Id
    private Integer id;
    private String authorName;
    private List<Book> bookList;

}
