package com.bruce.webflux;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.invoke.MethodHandles;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebfluxApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void test11() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.toString());
    }

    @Test
    public void test() {
        func(2, 0);
    }

    public void func(int r, int c) {
        r--;
        c++;
        if (r > 0 && c < 3) {
            func(r, c);
        } else {
            System.out.println("r = [" + r + "], c = [" + c + "]");
        }
    }

    @Test
    public void test1() {
        B b = new B();
    }

    private final static Comparator<Object> CHINA_COMPARE = Collator.getInstance(java.util.Locale.CHINESE);

    @Test
    public void test2() {

        List<String> cityList = new ArrayList<String>();
        List<String> cityList1 = new ArrayList<String>();
        cityList.add("上海");
        cityList.add("北京");
        cityList.add("安徽");
        cityList.add("重庆");
        cityList.add("潮州");
        cityList.add("广州");
        cityList.add("深圳");

        Collections.sort(cityList, CHINA_COMPARE);
        System.out.println("0----" + cityList);
        for (int i = 0; i < cityList.size(); i++) {
            String str = getAlphabet(cityList.get(i));
            cityList1.add(str);
        }
        Collections.sort(cityList1, CHINA_COMPARE);
        System.out.println("1----" + cityList1);
    }

    //todo 多音字处理
    //  https://blog.csdn.net/hao_kkkkk/article/details/51780719
    // https://blog.csdn.net/top_code/article/details/39641615
    public String getAlphabet(String str) {
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        // 输出拼音全部小写
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        // 不带声调
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        String pinyin = null;
        try {
            pinyin = (String) PinyinHelper.toHanyuPinyinStringArray(str.charAt(0), defaultFormat)[0];
            System.out.println("pinyin = [" + pinyin + "]");
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return pinyin.substring(0, 1);
    }
}

class A {
    static {
        System.out.println("----S-A---");
    }

    public A() {
        System.out.println("-----A-----");

    }
}

class B extends A {
    static {
        System.out.println("----S-B---");
    }

    public B() {
        System.out.println("----B---");
    }

    public static MethodHandles.Lookup lookup() {
        return MethodHandles.lookup();
    }
}


