package com.project.mealbong.user;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface User1Mapper {

    @Insert("insert into user(user_id,user_password,user_name," +
            "user_email,user_phone,user_zip," +
            "user_address1,user_address2,user_gender,user_birth,etc1)" +
            " values(#{user_id},#{user_password},#{user_name}," +
            "#{user_email},#{user_phone},#{user_zip},#{user_address1},#{user_address2}," +
            "#{user_gender},'1999-11-22',#{etc1}) ")
    int user_save(User1MapperDTO user1MapperDTO);


    @Select("select * from user")
    List<User1MapperDTO> user_list();


    @Delete("delete from user where user_id = #{user_id}")
    int user_delete(String user_id);


    @Select("select * from user where user_id = #{user_id}")
    User1MapperDTO find_id(String user_id);

    @Update("update user set user_email=#{user_email},user_phone=#{user_phone}," +
            "user_zip=#{user_zip},user_address2=#{user_address2}," +
            "user_gender=#{user_gender},etc1=${etc1} where user_id=#{user_id}")
    int user_update(User1MapperDTO user1MapperDTO);


}
