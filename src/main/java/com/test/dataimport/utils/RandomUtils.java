package com.test.dataimport.utils;

import java.util.Random;

public class RandomUtils {

    public static String getRandomName() {
        String ku = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder newStr = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            int r2 = r.nextInt(ku.length());
            newStr.append(ku.charAt(r2));
        }
        return newStr.toString();
    }


    public static String getRandomPhone() {
        String ku = "0123456789";
        StringBuilder newStr = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 11; i++) {
            int r2 = r.nextInt(ku.length());
            newStr.append(ku.charAt(r2));
        }
        return newStr.toString();
    }
}
