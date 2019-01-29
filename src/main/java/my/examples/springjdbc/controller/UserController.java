package my.examples.springjdbc.controller;

import my.examples.springjdbc.dto.User;
import my.examples.springjdbc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
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
    @GetMapping(value={"/list", "/main"})
    public String main(Model model){
        List<User> users = userService.selectAll();
        model.addAttribute("users", users);
        return "index"; // view name
    }

    @GetMapping("/join")
    public String joinform(){
        return "join";
    }

    @PostMapping("/join")
    public String join(@RequestParam(name = "inputName") String name,
                       @RequestParam(name = "nickName") String nickname,
                       @RequestParam(name = "inputEmail") String email,
                       @RequestParam(name = "inputPassword") String passwd,
                       @RequestParam(name = "inputPasswordCheck") String passwd2,
                       @RequestHeader(name = "Accept") String accept,
                       HttpSession session){
        Assert.hasLength(name, "이름을 입력하세요.");
        if(name == null || name.length() <= 1)
            throw new IllegalArgumentException("이름을 입력하세요.");
        System.out.println(passwd);
        System.out.println(passwd2);
        if(!passwd.equals(passwd2)) {
            throw new IllegalArgumentException("패스워드의 값이 다릅니다.");
        }
        userService.insertUser(name, nickname, email, passwd);

        return "redirect:/";

    }
}
