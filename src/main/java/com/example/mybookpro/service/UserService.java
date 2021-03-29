package com.example.mybookpro.service;

import com.example.mybookpro.dao.UserMapper;
import com.example.mybookpro.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    public List<User> queryUser(String username,String password){
        return userMapper.queryUser(username,password);
    }

    public List<User> queryUserByName(String name){
        return userMapper.queryUserByName(name);
    }

    public int addUser(User user){
        return userMapper.insertUser(user.getUsername(),user.getPassword());
    }

    public List<User> queryAllUser(){
        return userMapper.queryAllUser();
    }

    public int updateUserPWD(User user){
        return userMapper.updateUserPWD(user.getPassword(),user.getUsername());
    }
}
