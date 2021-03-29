package com.example.mybookpro.controller;

import com.example.mybookpro.entity.Comment;
import com.example.mybookpro.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/viewBook/queryCommentByBookId",method = RequestMethod.POST)
    public List<Map>queryCommentByBookId(@RequestBody Comment comment){
        List<Comment> list=commentService.queryCommentByBookId(comment.getBookId());
        List<Map> result=new ArrayList();
        for(Comment comment1:list){
            Map<String,Object> map=new HashMap<>();
            map.put("commenter",comment1.getCommenter());
            map.put("commentTime",comment1.getTime());
            map.put("commentContext",comment1.getContext());
            map.put("bookid",comment1.getBookId());
            result.add(map);
        }
        return result;
    }

    @RequestMapping(value = "/viewBook/addComment")
    public Map addComment(@RequestBody Comment comment){
        Map<String,String> msg=new HashMap<>();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = simpleDateFormat.format(date);
        if (commentService.insertComment(str,comment.getCommenter(),comment.getContext(),comment.getBookId())!=1){
            msg.put("code","500");//操作失败
        }else{
            msg.put("code","200");//操作成功
        }
        return msg;
    }
}
