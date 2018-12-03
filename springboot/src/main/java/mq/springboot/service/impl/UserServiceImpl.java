package mq.springboot.service.impl;

import mq.springboot.common.BaseResponse;
import mq.springboot.responsiry.UserResponsity;
import mq.springboot.responsiry.entity.UserEntity;
import mq.springboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserResponsity userResponsity;
    @Override
    public BaseResponse addUser() {
        UserEntity user01 = new UserEntity("张三", 18);
        UserEntity save = userResponsity.save(user01);
        return new BaseResponse(0, save, "success");
    }
}
