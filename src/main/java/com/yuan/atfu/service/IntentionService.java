package com.yuan.atfu.service;

import com.yuan.atfu.domain.entity.Intention;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.scheduling.annotation.Async;

/**
 * <p>
 * 咨询意向 服务类
 * </p>
 *
 * @author David
 * @since 2019-04-10
 */
public interface IntentionService extends IService<Intention> {

    @Async
    void sendEmail(Intention intention);

}
