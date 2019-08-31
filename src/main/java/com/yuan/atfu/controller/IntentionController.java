package com.yuan.atfu.controller;

import com.yuan.atfu.domain.entity.Intention;
import com.yuan.atfu.domain.vo.BaseResponse;
import com.yuan.atfu.domain.vo.IntentionForm;
import com.yuan.atfu.service.IntentionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author David Hong
 * @version 1.0
 * @description 询问下单controller
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/intention")
public class IntentionController {

    @Autowired
    private IntentionService intentionService;

    @PostMapping
    public BaseResponse post(@RequestBody IntentionForm reqIntention) {
        log.info(reqIntention.toString());
        Intention intention = new Intention();
        BeanUtils.copyProperties(reqIntention, intention);
        // 插入 咨询意向 记录
        intention.insert();
        // 发送邮件
        intentionService.sendEmail(intention);
        return BaseResponse.ok("我们已收到询价下单请求，我们会尽快联系您!");
    }

}
