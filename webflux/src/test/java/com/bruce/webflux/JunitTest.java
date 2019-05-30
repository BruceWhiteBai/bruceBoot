package com.bruce.webflux;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JunitTest {

    @Test
    public void test01(){
        System.out.println("1---"+checkMobile("12312312345111"));
    }

    private boolean checkMobile(String phone){
//        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        String regex = "^\\d{11}$";
        if (phone.length() != 11) {
            //return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            if (!isMatch) {
                return false;
            }
            return isMatch;
        }
        return true;
    }


    @Test
    public void test(){
        StringBuilder str = new StringBuilder("asdf,123,fff,");
        System.out.println(str.length());
        System.out.println(str.deleteCharAt(str.length()-1));
        System.out.println(str);
    }
}
