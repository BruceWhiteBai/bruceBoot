package com.bruce.webflux;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import net.coobird.thumbnailator.Thumbnails;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import java.io.File;
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
            Document doc= Jsoup.parse(new URL("html"),(1000_00));
            System.out.println(doc.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test11() throws IOException {
        Thumbnails.of("C:\\Users\\bzj\\Pictures\\1.jpg")
                .scale(1f)
                .outputQuality(0.2f)
                .toFile("C:\\Users\\bzj\\Pictures\\1-y.jpg");
    }


    @Test
    public void testExif() throws Exception {
        File jpegFile = new File("C:\\Users\\bzj\\Pictures\\1-y.jpg");
        Metadata metadata = ImageMetadataReader.readMetadata(jpegFile);
        for (Directory directory : metadata.getDirectories()) {
            for (Tag tag : directory.getTags()) {
                //格式化输出[directory.getName()] - tag.getTagName() = tag.getDescription()
                System.out.format("[%s] - %s = %s\n",
                        directory.getName(), tag.getTagName(), tag.getDescription());
            }
            if (directory.hasErrors()) {
                for (String error : directory.getErrors()) {
                    System.err.format("ERROR: %s", error);
                }
            }
        }

    }
}
