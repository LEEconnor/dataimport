package com.test.dataimport.utils;

import lombok.NonNull;

import java.util.Random;

public class RandomUtils {

//    所有的字母提取成常量
    public final static String LETTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

//    所有的数字提取成常量
    public final static String NUMBERS = "0123456789";

//    生成随机字符串
    public static String getRandomString(@NonNull String range, @NonNull Integer length) {
        if(length == 0){
            throw new RuntimeException("sorry , the length must be not null");
        }
        StringBuilder newStr = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            int r2 = r.nextInt(range.length());
            newStr.append(range.charAt(r2));
        }
        return newStr.toString();
    }


}
