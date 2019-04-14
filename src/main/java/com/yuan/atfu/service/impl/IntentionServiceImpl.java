package com.yuan.atfu.service.impl;

import com.yuan.atfu.domain.dto.Mail;
import com.yuan.atfu.domain.entity.Intention;
import com.yuan.atfu.mapper.IntentionMapper;
import com.yuan.atfu.service.IntentionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuan.atfu.service.MailSendService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 咨询意向 服务实现类
 * </p>
 *
 * @author David
 * @since 2019-04-10
 */
@Slf4j
@Service
public class IntentionServiceImpl extends ServiceImpl<IntentionMapper, Intention> implements IntentionService {

    @Autowired
    private MailSendService mailSendService;

    private String notifyEmail = "min@atfucomponents.com";

    @Override
    public void sendEmail(Intention intention) {
        long startTime = System.currentTimeMillis();

        Map<String, Object> params = new HashMap<>();
        params.put("company", intention.getCompany());
        params.put("contact", intention.getContact());
        params.put("email", intention.getEmail());
        params.put("fax", intention.getFax());
        params.put("more", intention.getMore());
        Mail mail = new Mail();
        mail.setEmail(notifyEmail);
        mail.setParams(params);
        mail.setTemplate("place_order.ftl");
        mail.setSubject("自动发送:客户询问下单邮件");
        mailSendService.sendWithHTMLTemplate(mail);

        long endTime = System.currentTimeMillis();
        log.info("发送邮件用时: {}ms", (endTime - startTime)/1000.0);
    }

}
