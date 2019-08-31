package com.yuan.atfu.domain.vo;

import lombok.Getter;

/**
 * @author David Hong
 * @version 1.0
 * @description 响应内容
 */
public enum BRStatus {

    SUCCESS(200, "SUCCESS"),
    SERVER_ERROR(700, "服务器异常");

    @Getter
    private final int status;

    @Getter
    private final String msg;

    BRStatus(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

}
