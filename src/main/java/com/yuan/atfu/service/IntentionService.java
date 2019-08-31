package com.yuan.atfu.service;

import com.yuan.atfu.domain.entity.Intention;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 咨询意向 服务类
 * </p>
 *
 * @author David
 * @since 2019-04-10
 */
public interface IntentionService extends IService<Intention> {

    /**
     * 发送邮件
     *
     * @param intention
     * @return void
     * @author David Hong
     */
    void sendEmail(Intention intention);

}
