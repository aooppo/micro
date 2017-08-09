/*
 * Copyright (c) 2017. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.trinitesolutions.demo.exception;

import com.trinitesolutions.demo.vo.Result;

public class NormalException extends RuntimeException {

    private Integer code;

    private String detailMsg;

    public NormalException(Integer code, String detailMsg) {
        this.code = code;
        this.detailMsg = detailMsg;
    }

    public NormalException(String message, Integer code, String detailMsg) {
        super(message);
        this.code = code;
        this.detailMsg = detailMsg;
    }

    public NormalException(String message, Throwable cause, Integer code, String detailMsg) {
        super(message, cause);
        this.code = code;
        this.detailMsg = detailMsg;
    }

    public NormalException(Throwable cause, Integer code, String detailMsg) {
        super(cause);
        this.code = code;
        this.detailMsg = detailMsg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDetailMsg() {
        return detailMsg;
    }

    public void setDetailMsg(String detailMsg) {
        this.detailMsg = detailMsg;
    }

    public Result<?> getResult() {
        Result<?> r = new Result<>();
        r.setCode(getCode());
        r.setMsg(getDetailMsg());
        return r;
    }

}
