package com.yuan.atfu.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author David Hong
 * @version 1.0
 * @description 基础响应封装
 */
@Data
public class BaseResponse {

    private static final DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 状态
     */
    private Integer status;
    /**
     * 消息
     */
    private String msg;
    /**
     * 内容
     */
    private Object content;
    /**
     * 时间
     */
    private String timestamp;

    private BaseResponse(BRStatus brStatus, Object content) {
        this.status = brStatus.getStatus();
        this.msg = brStatus.getMsg();
        this.content = content;
        this.timestamp = sdf.format(LocalDateTime.now());
    }

    private BaseResponse(BRStatus brStatus) {
        this.status =  brStatus.getStatus();
        this.msg = brStatus.getMsg();
        this.timestamp = sdf.format(LocalDateTime.now());
    }

    public static BaseResponse error() {
        return new BaseResponse(BRStatus.SERVER_ERROR);
    }

    public static BaseResponse error(BRStatus brStatus) {
        return new BaseResponse(brStatus);
    }

    public static BaseResponse ok() {
        return new BaseResponse(BRStatus.SUCCESS);
    }

    public static BaseResponse ok(Object content) {
        return new BaseResponse(BRStatus.SUCCESS, content);
    }

    public BaseResponse() {}

}
