package mq.springboot.user.service.impl;

import mq.springboot.common.response.BaseResponse;
import mq.springboot.user.responsiry.UserResponsity;
import mq.springboot.user.responsiry.entity.UserInfo;
import mq.springboot.user.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserResponsity userResponsity;
    @Override
    public BaseResponse addUser() {
//        UserInfo user01 = new UserInfo("张三", 18);
//        UserInfo save = userResponsity.save(user01);
//        return new BaseResponse(0, save, "success");
        return null;
    }

    @Override
    public UserInfo findByUsername(String username) {
        return null;
    }
}
