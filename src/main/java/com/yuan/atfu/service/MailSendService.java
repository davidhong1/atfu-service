package com.yuan.atfu.service;

import com.yuan.atfu.domain.dto.Mail;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.Map;

/**
 * @Description:
 * @Author: mac
 * @Date: 2019-04-14 10:43
 * @Version: 0.1
 **/
public interface MailSendService {

    String getMailTextByTemplateName(String templateName, Map<String,Object> params) throws IOException, TemplateException;

    boolean sendWithHTMLTemplate(Mail mail);

}
