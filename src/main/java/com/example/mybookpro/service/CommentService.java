package com.example.mybookpro.service;

import com.example.mybookpro.dao.CommentMapper;
import com.example.mybookpro.entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Time;
import java.util.List;

@Service
public class CommentService {
    @Resource
    CommentMapper commentMapper;

    public List<Comment> queryCommentByBookId(int bookId){
        return commentMapper.queryCommentByBookId(bookId);
    }

    public int insertComment(String time, String commenter, String content, int bookId){
        return commentMapper.insertComment(time,commenter,content,bookId);
    };
}
