package my.examples.springjdbc;

import my.examples.springjdbc.config.ApplicationConfig;
import my.examples.springjdbc.dto.User;
import my.examples.springjdbc.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-24
 * Github : https://github.com/YeoHoonYun
 */
public class UserServiceTestApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        UserService userService = applicationContext.getBean(UserService.class);
        for (User user : userService.selectAll()){
            System.out.println(user);
        }

        Long id = userService.insertUser("윤여훈", "Hoon", "cjswo9207@gmail.com","1234");
        System.out.println(id);
    }
}
