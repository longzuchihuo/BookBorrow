package com.example.mybookpro.entity;

import lombok.Data;

@Data
public class Book {
    private String bookname;
    private int id;
    private String author;
    private String classification;
    private String img;
    private int status;
    private String master;
}
