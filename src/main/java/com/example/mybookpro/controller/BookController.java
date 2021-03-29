package com.example.mybookpro.controller;

import com.example.mybookpro.entity.Book;
import com.example.mybookpro.entity.User;
import com.example.mybookpro.service.BookService;
import com.example.mybookpro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    UserService userService;

    @RequestMapping(value ="/page/queryBookByClassification",method = RequestMethod.POST)
    public List<Map> queryBookByClassification(@RequestBody Book mybook){
        //System.out.println(mybook.getClassification());
        List<Book> list=bookService.queryBookByClassification(mybook.getClassification());
        //System.out.println(list);
        List<Map> result=new ArrayList();
        for(Book book:list){
            Map<String,Object> map=new HashMap<>();
            map.put("bookname",book.getBookname());
            map.put("id",book.getId());
            map.put("author",book.getAuthor());
            map.put("classifiaction",book.getClassification());
            map.put("img",book.getImg());
            map.put("status",book.getStatus());
            map.put("master",book.getMaster());
            result.add(map);
        }
        return result;
    }

    @RequestMapping(value = "/bookMannger/deleteBook",method = RequestMethod.POST)
    public Map deleteBook(@RequestBody Book book){
        Map<String,String> msg=new HashMap<>();
        if (bookService.deleteBook(book.getId())!=1){
            msg.put("code","500");//操作失败
        }else{
            msg.put("code","200");//操作成功
        }
        return msg;
    }

    @RequestMapping(value = "/bookMannger/queryBook",method = RequestMethod.POST)
    public List<Map>queryBookById(@RequestBody Book mybook){
        List<Book> list=bookService.queryBookById(mybook.getMaster());
        List<Map> result=new ArrayList();
        for(Book book:list){
            Map<String,Object> map=new HashMap<>();
            map.put("bookname",book.getBookname());
            map.put("bookid",book.getId());
            map.put("author",book.getAuthor());
            map.put("classifiaction",book.getClassification());
            map.put("img",book.getImg());
            if(book.getStatus()==0){
                map.put("bookstatus","可借阅");
            }else{
                map.put("bookstatus","借阅中");
            }
            map.put("master",book.getMaster());
            result.add(map);
        }
        return result;
    }

    @RequestMapping(value = "/bookMannger/updatBookStatus",method = RequestMethod.POST)
    public Map updatBookStatus(@RequestBody Book mybook){
        //System.out.println(mybook.getStatus());
        Map<String,String> msg=new HashMap<>();
        if (bookService.updatBookStatus(mybook.getStatus(),mybook.getId())!=1){
            msg.put("code","500");//操作失败
        }else{
            msg.put("code","200");//操作成功
        }
        return msg;
    }

    @RequestMapping(value = "/bookMannger/addBook",method =RequestMethod.POST)
    public Map addBook(@RequestBody Book mybook){
        Map<String,String> msg=new HashMap<>();
        if (bookService.insertBook(mybook.getBookname(),0,mybook.getAuthor(),mybook.getClassification(),
                "src",0,mybook.getMaster())!=1){
            msg.put("code","500");//操作失败
        }else{
            msg.put("code","200");//操作成功
        }
        return msg;
    }
}
