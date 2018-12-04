package mq.springboot.user.service;

import mq.springboot.common.response.BaseResponse;
import mq.springboot.user.responsiry.entity.UserInfo;

public interface UserInfoService {

    BaseResponse addUser();

    UserInfo findByUsername(String username);
}
