package com.yuan.atfu.domain.vo;

import lombok.Data;

/**
 * @Description:
 * @Author: mac
 * @Date: 2019-04-13 12:51
 * @Version: 0.1
 **/
@Data
public class ReqIntention {

    /**
     * 咨询公司
     */
    private String company;

    /**
     * 联系方式
     */
    private String contact;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 传真
     */
    private String fax;

    /**
     * 用户备注
     */
    private String more;


}
