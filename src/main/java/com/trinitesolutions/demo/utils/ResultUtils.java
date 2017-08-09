/*
 * Copyright (c) 2017.  TJ
 */

package com.trinitesolutions.demo.utils;

import com.trinitesolutions.demo.vo.Result;

public class ResultUtils {

    public static Result success(Object o) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("successful.");
        result.setData(o);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
