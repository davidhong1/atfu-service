package com.yuan.atfu;

import com.yuan.atfu.domain.dto.EmailSend;
import com.yuan.atfu.service.MailSendService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AtfuApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Autowired
    private JavaMailSender mailSender;

    @Test
    public void sendSimpleMail() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1751632917@qq.com");
        message.setTo("1751632917@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");

        mailSender.send(message);
    }

    @Autowired
    private MailSendService mailSendService;

    @Test
    public void test1() throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("username", "itf");
        EmailSend mail  = new EmailSend();
        mail.setEmail("1751632917@qq.com");
        mail.setParams(params);
        mail.setTemplate("place_order.ftl");
        mail.setSubject("登录验证码");
        mailSendService.sendWithHTMLTemplate(mail);
    }

}
