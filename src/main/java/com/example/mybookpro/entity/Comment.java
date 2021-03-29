package com.example.mybookpro.entity;

import lombok.Data;

import java.sql.Time;

@Data
public class Comment {
    private String time;
    private String commenter;
    private String context;
    private int bookId;
}
