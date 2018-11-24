package com.bruce.util.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by BruceWhite on 2018/11/24.
 */
@Service("javaMail")
public class JavaMail {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String form;

    /**
     * @description :
     * @param:[to, subject, content]
     * @return:void
     * @author:BruceWhite
     * @createTime:2018/11/24
     */
    public void sendMail(String to, String subject, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(form);
        mailMessage.setTo(to);
        //如果发给多个人的：
        //mailMessage.setTo("1xx.com","2xx.com","3xx.com");    
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        try {
            javaMailSender.send(mailMessage);
            System.out.println("发送简单邮件");
        } catch (Exception e) {
            System.out.println("发送简单邮件失败");
        }
    }


    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(form);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            javaMailSender.send(message);
            System.out.println("html格式邮件发送成功");
        } catch (Exception e) {
            System.out.println("html格式邮件发送失败");
        }
    }

    public void sendAttachmentsMail(String to, String subject, String content, String[] filePath) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(form);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);
            if (filePath.length > 0) {
                for (int i=0;i<filePath.length;i++){
                    FileSystemResource file=new FileSystemResource(new File(filePath[i]));
                    String fileName=filePath[i].substring(filePath[i].lastIndexOf(File.separator));
                    helper.addAttachment(fileName,file);
                }
            }

            javaMailSender.send(message);
            System.out.println("带附件的邮件发送成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("发送带附件的邮件失败");
        }
    }


}
