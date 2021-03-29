package com.example.mybookpro.service;

import com.example.mybookpro.dao.BookMapper;
import com.example.mybookpro.entity.Book;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookService {
    @Resource
    BookMapper bookMapper;

    public List<Book> queryBookByClassification(String classification){
//        if(bookMapper.queryBookByClassification(classification).isEmpty()){
//            //System.out.println(classification);
//        }
        return bookMapper.queryBookByClassification(classification);
    }

    public int deleteBook(int id){
        return bookMapper.deleteBook(id);
    }

    public List<Book> queryBookById(String master){
        return bookMapper.queryBookByMaster(master);
    }

    public int updatBookStatus(int status,int id){
        return bookMapper.updatBookStatus(status,id);
    }

    public int insertBook(String bookname,int id,String author,String classification,String img,int status,String master){
        return bookMapper.insertBook(bookname,id,author,classification,img,status,master);
    }
}
