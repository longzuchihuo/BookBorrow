package com.example.mybookpro.dao;

import com.example.mybookpro.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {
    @Select(value = "select * from book where classification=#{classification}")
    public List<Book> queryBookByClassification(@Param("classification")String classification);

    @Select(value = "select * from book where master=#{master}")
    public List<Book> queryBookByMaster(@Param("master")String master);

    @Delete(value = "delete from book where id=#{id}")
    public int deleteBook(@Param("id")int id);

    @Update(value = "update book set status=#{status} where id=#{id}")
    public int updatBookStatus(@Param("status")int status,@Param("id")int id);

    @Insert(value = "insert into book(bookname,id,author,classification,img,status,master) values(#{bookname},#{id},#{author},#{classification},#{img},#{status},#{master})")
    public int insertBook(@Param("bookname")String bookname,@Param("id")int id,
                          @Param("author")String author,@Param("classification")String classification,
                          @Param("img")String img,@Param("status")int status,
                          @Param("master")String master);
}
