package mq.springboot.common.response;

import lombok.Data;

@Data
public class BaseResponse {
    private Integer code;
    private Object data;
    private String msg;

    public BaseResponse(Integer code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
