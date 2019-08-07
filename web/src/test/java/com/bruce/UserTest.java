package com.bruce;

import com.bruce.entity.dto.User;
import com.bruce.service.userService.UserService;
import com.bruce.util.mail.JavaMail;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest extends WebApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    JavaMail javaMail;

    @Test
    public void test01(){
        User user = userService.getUserById(String.valueOf(1));
        System.out.println("user obj " + user.getUserId() );

    }

    @Test
    public void testMail(){
        javaMail.sendMail("1258444549@qq.com","哈喽","this mail from boot" , new String[]{"1602094132@qq.com"}, new String[]{"bcc"});//todo

    }

    @Test
    public void testHtmlMail(){
        javaMail.sendHtmlMail("1258444549@qq.com","哈喽","<h1>this mail from boot</h1>" , null, null);

    }

    @Test
    public void sendAttachmentsMail(){
        String f1 = "C:\\Users\\BruceWhite\\Pictures\\Camera Roll\\1.gif";
        String f2 = "C:\\Users\\BruceWhite\\Pictures\\Camera Roll\\1.gif";
        javaMail.sendAttachmentsMail("1258444549@qq.com","哈喽","<h1>this mail from boot</h1>" ,new String[]{f1,f2} , null, null);

    }
}
