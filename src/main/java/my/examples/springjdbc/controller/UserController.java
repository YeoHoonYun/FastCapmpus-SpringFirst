package my.examples.springjdbc.controller;

import my.examples.springjdbc.dto.User;
import my.examples.springjdbc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by cjswo9207u@gmail.com on 2019-01-28
 * Github : https://github.com/YeoHoonYun
 */
@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    //  @RequestMapping(method=GET, path="/list") 와 같은 것
    @GetMapping("/list")
    public String main(Model model){
        List<User> users = userService.selectAll();
        model.addAttribute("users", users);
        return "index"; // view name
    }

}
