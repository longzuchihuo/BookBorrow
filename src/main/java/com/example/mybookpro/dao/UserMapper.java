package com.example.mybookpro.dao;

import com.example.mybookpro.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select(value = "select * from user where username=#{username} and password=#{password}")
    public List<User> queryUser(@Param("username")String username,@Param("password") String password);

    @Select(value = "select * from user")
    public List<User> queryAllUser();

    @Insert(value = "insert into user(username,password) values(#{username},#{password})")
    public int insertUser(@Param("username")String username,@Param("password")String password);

    @Select(value = "select * from user where username=#{username}")
    public List<User> queryUserByName(@Param("username")String username);

    @Update(value = "update user set password=#{password} where username=#{username}")
    public int updateUserPWD(@Param("password")String password,@Param("username")String username);
}
