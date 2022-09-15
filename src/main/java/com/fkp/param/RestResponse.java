package com.fkp.param;

import com.fkp.util.I18nUtils;

import java.io.Serializable;

public class RestResponse<T> implements Serializable {
    private static final long serialVersionUID = 2621638727631497840L;
    private static final String CODE_SUCCESS = "000000";
    private static final String STATUS_SUCCESS = "success";
    private static final String STATUS_FAIL = "fail";

    private String code;
    private String status;
    private String msg;
    private T data;

    public RestResponse() {
    }

    public RestResponse(String code, String status) {
        this.code = code;
        this.status = status;
        this.msg = I18nUtils.getMessage(code);
    }

    public RestResponse(String code, String status, String msg) {
        this.code = code;
        this.status = status;
        this.msg = msg;
    }

    public RestResponse(String code, String status, T data) {
        this.code = code;
        this.status = status;
        this.msg = I18nUtils.getMessage(code);
        this.data = data;
    }

    public RestResponse(String code, String status, String msg, T data) {
        this.code = code;
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public static <T> RestResponse<T> success(){
        RestResponse<T> res = new RestResponse<>();
        res.setCode(CODE_SUCCESS);
        res.setStatus(STATUS_SUCCESS);
        res.setMsg(I18nUtils.getMessage(CODE_SUCCESS));
        return res;
    }

    public static <T> RestResponse<T> success(String msg){
        RestResponse<T> res = new RestResponse<>();
        res.setCode(CODE_SUCCESS);
        res.setStatus(STATUS_SUCCESS);
        res.setMsg(msg);
        return res;
    }

    public static <T> RestResponse<T> success(T data){
        RestResponse<T> res = new RestResponse<>();
        res.setCode(CODE_SUCCESS);
        res.setStatus(STATUS_SUCCESS);
        res.setMsg(I18nUtils.getMessage(CODE_SUCCESS));
        res.setData(data);
        return res;
    }

    public static <T> RestResponse<T> success(String msg, T data){
        RestResponse<T> res = new RestResponse<>();
        res.setCode(CODE_SUCCESS);
        res.setStatus(STATUS_SUCCESS);
        res.setMsg(msg);
        res.setData(data);
        return res;
    }

    public static <T> RestResponse<T> fail(String code){
        RestResponse<T> res = new RestResponse<>();
        res.setCode(code);
        res.setStatus(STATUS_FAIL);
        res.setMsg(I18nUtils.getMessage(code));
        return res;
    }

    public static <T> RestResponse<T> fail(String code, String msg){
        RestResponse<T> res = new RestResponse<>();
        res.setCode(code);
        res.setStatus(STATUS_FAIL);
        res.setMsg(msg);
        return res;
    }

    public static <T> RestResponse<T> fail(String code, T data){
        RestResponse<T> res = new RestResponse<>();
        res.setCode(code);
        res.setStatus(STATUS_FAIL);
        res.setMsg(I18nUtils.getMessage(code));
        res.setData(data);
        return res;
    }

    public static <T> RestResponse<T> fail(String code, String msg, T data){
        RestResponse<T> res = new RestResponse<>();
        res.setCode(code);
        res.setStatus(STATUS_FAIL);
        res.setMsg(msg);
        res.setData(data);
        return res;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
