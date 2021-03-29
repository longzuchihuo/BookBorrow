package com.example.mybookpro.controller;

import com.example.mybookpro.Result.CommonResult;
import com.example.mybookpro.entity.User;
import com.example.mybookpro.service.UserService;
import com.example.mybookpro.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login/queryUser",method = RequestMethod.POST)
    public Map queryUser(@RequestBody User user){
        //System.out.println(user.getUsername()+" "+user.getPassword());
        List<User> usersList=userService.queryUser(user.getUsername(),user.getPassword());
        Map<String,String> msg=new HashMap<>();
        if(usersList.isEmpty()){
            msg.put("code","401");
            msg.put("message","用户名密码错误");
            return msg;
        }else{
            String token= TokenUtils.token(user.getUsername(),user.getPassword());
            msg.put("code","200");
            msg.put("username",user.getUsername());
            msg.put("token",token);
            return msg;
        }
    }

    @RequestMapping(value = "/register/addUser",method = RequestMethod.POST)
    public Map addUser(@RequestBody User user){
        Map<String,String> msg=new HashMap<>();
        if(userService.queryUserByName(user.getUsername()).isEmpty()){
            if(userService.addUser(user)!=1){
                msg.put("code","500");//操作失败
            }else{
                msg.put("code","200");//操作成功
            }
        }else{
            msg.put("code","405");//用户名已存在
        }
        return msg;
    }

    @RequestMapping(value = "/updatePassword/uupadtePWD",method = RequestMethod.POST)
    public Map upadtePWD(@RequestBody User user){
        Map<String,String> msg=new HashMap<>();
        if(userService.queryUserByName(user.getUsername()).isEmpty()){
            msg.put("code","405");//用户不存在
        }else{
            if(userService.updateUserPWD(user)!=1){
                msg.put("code","500");//操作失败
            }else{
                msg.put("code","200");//操作成功
            }
        }
        return msg;
    }


//    @GetMapping("/queryAllUser")
//    public List<User> quertAllUser(){
//        return userService.queryAllUser();
//    }
}
