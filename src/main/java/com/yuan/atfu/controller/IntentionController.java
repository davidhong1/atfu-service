package com.yuan.atfu.controller;

import com.yuan.atfu.domain.entity.Intention;
import com.yuan.atfu.domain.vo.BRB;
import com.yuan.atfu.domain.vo.BRStatus;
import com.yuan.atfu.domain.vo.ReqIntention;
import com.yuan.atfu.service.IntentionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 咨询意向 前端控制器
 * </p>
 *
 * @author David
 * @since 2019-04-10
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/intention")
public class IntentionController {

    @Autowired
    private IntentionService intentionService;

    // TODO 参数校验和对象拷贝
    @PostMapping
    public BRB post(@RequestBody ReqIntention reqIntention) {
        log.info(reqIntention.toString());
        Intention intention = new Intention();
        BeanUtils.copyProperties(reqIntention, intention);
        log.info(intention.toString());
        intentionService.save(intention);
        // 发送邮件
        intentionService.sendEmail(intention);
        return new BRB(BRStatus.SUCCESS, "我们已收到询价下单请求，我们会尽快联系您!");
    }

}
