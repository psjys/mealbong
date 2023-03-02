package com.project.mealbong.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User1ServiceImpl implements User1Service{

    @Autowired
    private User1Mapper user1Mapper;

    @Override
    public int user_update(User1MapperDTO user1MapperDTO) {
        return user1Mapper.user_update(user1MapperDTO);
    }

    @Override
    public int user_save(User1MapperDTO user1MapperDTO) {
       return user1Mapper.user_save(user1MapperDTO);

    }

    @Override
    public List<User1MapperDTO> user_list() {
        return user1Mapper.user_list();
    }

    @Override
    public int user_delete(String user_id) {
       return user1Mapper.user_delete(user_id);

    }

    @Override
    public User1MapperDTO find_id(String user_id) {
        return user1Mapper.find_id(user_id);
    }
}
