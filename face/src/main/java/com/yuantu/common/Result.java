package com.yuantu.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 接口返回参数
 * Created by brj on 2017/9/12.
 */
@ApiModel("响应结果")
public class Result implements Serializable {
    @ApiModelProperty("是否成功")
    private boolean success;
    @ApiModelProperty("成功或失败的信息")
    private String msg;
    @ApiModelProperty("响应数据")
    private Object data;

    public static Result createFailResult() {
        return createFailResult("操作失败");
    }

    public static Result createFailResult(String msg) {
        Result result = new Result();
        result.success = false;
        result.msg = msg;
        result.data = null;
        return result;
    }

    public static Result createSuccessResult() {
        return createSuccessResult(null);
    }

    public static Result createSuccessResult(Object data) {
        Result result = new Result();
        result.success = true;
        result.msg = "操作成功";
        result.data = data;
        return result;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
