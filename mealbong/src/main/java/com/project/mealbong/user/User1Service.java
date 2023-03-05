package com.project.mealbong.user;

import java.util.List;

public interface User1Service {
    int user_save(User1MapperDTO user1MapperDTO);

    List<User1MapperDTO> user_list();

    int user_delete(String user_id);

    User1MapperDTO find_id(String user_id);

    int user_update(User1MapperDTO user1MapperDTO);

    int id_check(String user_id);

    int email_check(String user_email);

    int phone_check(String user_phone);

    //User1MapperDTO pw_check(User1MapperDTO user1MapperDTO);
}
