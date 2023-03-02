package com.project.mealbong.user;

import java.util.List;

public interface User1Service {
    int user_save(User1MapperDTO user1MapperDTO);

    List<User1MapperDTO> user_list();

    int user_delete(String user_id);

    User1MapperDTO find_id(String user_id);

    int user_update(User1MapperDTO user1MapperDTO);
}
