package com.test.dataimport.utils;

import lombok.Data;

@Data
/**
 * controller结果返回封装类
 * */
public class Result {

    private Boolean success;

    private String message;

    private String data;

    private static Result successResult;

    static{
        successResult = new Result(true,"success");
    }

    public static Result getSuccessResult(String data) {
        successResult.setData(data);
        return successResult;
    }

    private Result(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

}
