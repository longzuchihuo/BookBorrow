package com.example.mybookpro.dao;

import com.example.mybookpro.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Time;
import java.util.List;

@Mapper
public interface CommentMapper {
    @Select(value = "select * from comment where bookId=#{bookId}")
    public List<Comment> queryCommentByBookId(@Param("bookId")int bookId);

    @Insert(value = "insert into comment(time,commenter,content,bookId) values(#{time},#{commenter},#{content},#{bookId})")
    public int insertComment(@Param("time")String time,@Param("commenter")String commenter,@Param("content")String content,
                             @Param("bookId")int bookId);
}
