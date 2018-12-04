package mq.springboot.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mq.springboot.common.response.BaseResponse;
import mq.springboot.user.dto.UserLoginRequest;
import mq.springboot.user.responsiry.entity.UserInfo;
import mq.springboot.user.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

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


//    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception{
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");
        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        // 此方法不处理登录成功,由shiro进行处理
        return "/login";
    }

    @PostMapping("/login2")
    @ApiOperation(value = "用户登录")
    public BaseResponse login2(@RequestBody UserLoginRequest userLoginRequest, HttpSession session){

        Subject subject = SecurityUtils.getSubject();
        //判断用户是否登录了
        if(subject.isAuthenticated()) {
            return new BaseResponse(0, null, "处于登录状态");
        }

        //获取UsernamePasswordToken
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userLoginRequest.getUsername(), userLoginRequest.getPassword());

        /**
         * shiro帮我们匹配密码什么的，我们只需要把东西传给它，它会根据我们自定义的Realm类里认证方法设置的来验证
         */
        subject.login(usernamePasswordToken);

        //可以从subject 中获取到登录的用户
        UserInfo userInfo = (UserInfo) subject.getPrincipal();
        //把用户信息放入session中
        session.setAttribute("user", userInfo);
        return new BaseResponse(0, userInfo, "success");
    }

    @GetMapping("/logout2")
    @ApiOperation(value = "退出登录")
    public BaseResponse logout2(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return new BaseResponse(0, "success", "logout success");
    }


}
