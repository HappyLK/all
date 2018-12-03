package boot.boot.A.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/user")
    public void home() {
        System.out.println("user user");
    }

    @RequestMapping("/user2")
    public void home2() {
        System.out.println("user user2");
    }
}
