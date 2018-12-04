package mq.springboot.user.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

/**
 * @author V_Happy.L.K
 * @date 2018/12/4 19:55
 */
@Getter
@Setter
@ApiModel("用户登录请求")
public class UserLoginRequest {
    /**
     * 帐号
     */
    @Column(unique =true)
    private String username;

    /**
     * 密码;
     */
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
