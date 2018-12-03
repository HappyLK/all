package mq.springboot.controller;

import mq.springboot.common.BaseResponse;
import mq.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/addUser")
    public BaseResponse addUser() {
        System.out.println("aaaaaaaa");
        BaseResponse baseResponse = userService.addUser();
        System.out.println("bbbbbb");
        return baseResponse;
    }
}
