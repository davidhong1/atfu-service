package com.yuan.atfu.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author David Hong
 * @version 1.0
 * @description 发送的邮件内容
 */
@Data
public class EmailSend implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 接收方邮件
     */
    private String email;

    /**
     * 主题
     */
    private String subject;

    /**
     * 模板
     */
    private String template;

    /**
     * 自定义参数
     */
    private Map<String, Object> params;

}
