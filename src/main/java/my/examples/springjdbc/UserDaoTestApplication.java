package my.examples.springjdbc;

import my.examples.springjdbc.config.ApplicationConfig;
import my.examples.springjdbc.dao.UserDao;
import my.examples.springjdbc.dto.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-24
 * Github : https://github.com/YeoHoonYun
 */
public class UserDaoTestApplication{
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserDao userDao = applicationContext.getBean(UserDao.class);

//        for (User user : userDao.selectAll()){
//            System.out.println(user);
//        }

        Long id = userDao.insertUser("윤여훈", "Hoon", "cjswo9207@gmail.com","1234");
        System.out.println(id);
    }
}
