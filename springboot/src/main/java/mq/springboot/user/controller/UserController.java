package mq.springboot.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mq.springboot.common.response.BaseResponse;
import mq.springboot.user.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api(tags = "用户模块")
public class UserController {

    @Resource
    private UserInfoService userInfoService;

    @GetMapping("/addUser")
    @ApiOperation(value = "添加用户")
    public BaseResponse addUser() {
        System.out.println("aaaaaaaa");
        BaseResponse baseResponse = userInfoService.addUser();
        System.out.println("bbbbbb");
        return baseResponse;
    }
}
