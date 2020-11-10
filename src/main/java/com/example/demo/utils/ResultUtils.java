package com.example.demo.utils;

import com.example.demo.utils.Result;

import javax.servlet.http.HttpServletResponse;

/**
 * 返回结果工具类，用于ajax、REST等类型的web服务
 */
public class ResultUtils {

    private HttpServletResponse sc; // 异常状态码码
    private String message; // 提示信息
    private Object data; // 返回数据

    private ResultUtils(){}

    /**
     * 成功：(200, "success", null)
     */
    public static Result success(){
        return success("success");
    }

    /**
     * 成功：(200, 自定义消息, null)
     */
    public static Result success(String msg){
        return success(msg, null);
    }

    /**
     * 成功：(200 "success" 数据)
     */
    public static Result success(Object data){
        return success("success", data);
    }

    /**
     * 成功：(200 自定义消息 数据)
     */
    public static Result success(String msg, Object data){
        return success(HttpServletResponse.SC_OK, msg, data);
    }

    /**
     * 成功
     * @param status 状态码
     * @param msg 消息
     * @param data 数据
     */
    public static Result success(Integer status, String msg, Object data) {
        Result result = new Result();
        result.setStatus(status);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }


    /**
     * 失败 (400, "请求错误")
     */
    public static Result failure4(){
        return failure4("bad request");
    }
    public static Result failure4(String msg) {
        return failure(HttpServletResponse.SC_BAD_REQUEST, msg);
    }

    /**
     * 失败 (500, "服务器异常")
     */
    public static Result failure5(){
        return failure(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "server error");
    }

    /**
     * 失败 (状态码, 自定义消息, null)
     * @param status 状态码
     * @param msg 消息
     */
    public static Result failure(Integer status, String msg){
        return failure(status, msg, null);
    }

    /**
     * 失败
     * @param status 状态码
     * @param msg 消息
     * @param data 数据
     */
    public static Result failure(Integer status, String msg, Object data) {
        Result result = new Result();
        result.setStatus(status);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }
}

