package com.bruce.webflux;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
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

    @Test
    public void test1(){
        try {
            Document doc= Jsoup.parse(new URL("http://172.16.100.203:7067/sv/rest/protocol/query/protocolHtml?param=F514A02BE5A15752DA42C55A207E45C314E11EF8455D50F3E574CBC4C4955198"),(1000_00));
            System.out.println(doc.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
