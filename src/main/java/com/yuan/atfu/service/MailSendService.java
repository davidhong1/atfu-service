package com.yuan.atfu.service;

import com.yuan.atfu.domain.dto.EmailSend;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.Map;

/**
 * @author David Hong
 * @version 1.0
 * @description 邮件发送服务
 */
public interface MailSendService {

    /**
     * 使用模板生成html邮件内容
     *
     * @param templateName
     * @param params
     * @return java.lang.String
     * @author David Hong
     */
    String getMailTextByTemplateName(String templateName, Map<String,Object> params) throws IOException, TemplateException;

    /**
     * 发送邮件
     *
     * @param mail
     * @return boolean
     * @author David Hong
     */
    boolean sendWithHTMLTemplate(EmailSend mail);

}
