package com.yuan.atfu.service.impl;

import com.yuan.atfu.domain.dto.EmailSend;
import com.yuan.atfu.service.MailSendService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import java.io.IOException;
import java.util.Map;

/**
 * @Description:
 * @Author: mac
 * @Date: 2019-04-14 10:45
 * @Version: 0.1
 **/
@Slf4j
@Service
public class MailSendServiceImpl implements MailSendService {

    /**
     * 发件人昵称
     */
    @Value("${sender.nickname}")
    private String SENDER_NICKNAME;

    /**
     * 通知邮件接收方
     */
    @Value("${notify.email}")
    private String NOTIFY_EMAIL;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    @Override
    public String getMailTextByTemplateName(String templateName, Map<String, Object> params) throws IOException, TemplateException {
        String mailText = "";
        // 通过指定模板名获取FreeMarker模板实例
        Template template = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
        // FreeMarker通过Map传递动态数据
        // 注意动态数据的key和模板标签中指定的属性相匹配
        // 解析模板并替换动态数据，最终code将替换模板文件中的${code}标签。
        mailText = FreeMarkerTemplateUtils.processTemplateIntoString(template, params);
        return mailText;
    }

    @Override
    public boolean sendWithHTMLTemplate(EmailSend mail) {
        // 设置邮件接收方
        mail.setEmail(NOTIFY_EMAIL);
        try {
            String nick = MimeUtility.encodeText(SENDER_NICKNAME);
            //发件人, 这里邮件是我自己发给我我自己.. 接受方和发送方都是 NOTIFY_EMAIL: 1751632917@qq.com
            InternetAddress from = new InternetAddress(nick + "<" + NOTIFY_EMAIL + ">");
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(mail.getEmail());
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setSubject(mail.getSubject());
            // 使用模板生成html邮件内容
            String result = getMailTextByTemplateName(mail.getTemplate(), mail.getParams());
            mimeMessageHelper.setText(result, true);
            javaMailSender.send(mimeMessage);
            return true;
        } catch (Exception e) {
            log.error("发送邮件失败" + e.getMessage());
            return false;
        }
    }

}
