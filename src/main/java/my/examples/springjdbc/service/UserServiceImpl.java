package my.examples.springjdbc.service;

import com.sun.javafx.collections.MappingChange;
import my.examples.springjdbc.dao.UserDao;
import my.examples.springjdbc.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-24
 * Github : https://github.com/YeoHoonYun
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    @Transactional
    public Long insertUser(String name, String nickname, String email, String passwd){
        Long id = userDao.insertUser(name, nickname, email, passwd);
        return id;
    }

    @Override
    public String emailToPasswd(String email){
        String passwd = userDao.emailToPasswd(email);
        return passwd;
    }

    @Override
    public User emailToUser(String email){
        User user = userDao.emailToUser(email);
        return user;
    }
}
