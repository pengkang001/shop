package com.codewolf.shop.util;

public class StringUtil {
    public static Boolean isNull(String str){
        if (str == null){
            return true;
        }else if (str.trim().equals("")){
            return true;
        }
        return false;
    }
}
