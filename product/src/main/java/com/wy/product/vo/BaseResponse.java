package com.wy.product.vo;


import java.io.Serializable;

/**
 * @author HelloWorld
 * @create 2022/10/16 10:32
 * @email helloworld.dng@gmail.com
 */
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String state;
    private String msg;

    private Object data;

    public BaseResponse() {
        this.state = "S100";
        this.msg = "success";
    }
    public static BaseResponse ok(){
        return new BaseResponse();
    }

    public BaseResponse setData(Object data) {
        this.data = data;
        return this;
    }
}
