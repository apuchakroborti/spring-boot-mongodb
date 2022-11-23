package com.apu.mongodb.springbootmongodb.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@Document(collection = "book")
public class Book {
    @Id
    private Integer id;
    private String bookName;
    private Integer authorId;
}
