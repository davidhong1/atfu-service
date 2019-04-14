package com.yuan.atfu.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @Description:
 * @Author: mac
 * @Date: 2019-04-14 10:42
 * @Version: 0.1
 **/
@Data
public class Mail implements Serializable {

    private static final long serialVersionUID = 1L;

    //接收方邮件
    private String email;

    //主题
    private String subject;
    //模板
    private String template;

    // 自定义参数
    private Map<String, Object> params;

}
