package my.examples.springjdbc.service;

import my.examples.springjdbc.dto.User;

import java.util.List;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-24
 * Github : https://github.com/YeoHoonYun
 */
public interface UserService {
    public List<User> selectAll();

    Long insertUser(String name, String nickname, String email, String passwd);

    String emailToPasswd(String email);

    User emailToUser(String email);
}
