package com.yuan.atfu.domain.vo;

import lombok.Getter;
import lombok.Setter;

public enum BRStatus {

    SUCCESS(200, "SUCCESS"),
    CODEERROE(726, "验证码错误或已失效"),
    USER_LOGIN_INFO_EXCEPTION(722, "用户登录信息异常"),
    FORM_ERROR(721, "字段验证异常"),
    SYSTEM_MSG_TYPE_ERROR(722, "系统消息获取类型错误！"),
    SERVER_ERROR(700, "服务器异常"),
    INSERT_ERROR(723, "添加失败"),
    GET_ERROR(724, "并未获取到信息"),
    DELETE_ERROR(725, "删除操作无效"),
    USER_UNEXIST(726, "负责人手机号不存在"),
    UPDATE_ERROR(727, "修改操作无效"),
    DOWNLOAD_ERROR(728, "获取下载路径失败"),
    INVITE_CODE_ERROR(729, "邀请码错误或已失效"),
    PHONE_EXIST(730, "该手机号已存在"),
    USERNAME_EXIST(731, "该用户名已存在"),
    PARAS_ERROR(732, "参数有误"),
    USER_NOT_EXIST(733, "用户不存在"),
    PW_ERROR(734, "密码错误");

    @Setter
    @Getter
    private final int status;
    @Setter
    @Getter
    private final String msg;

    BRStatus(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

}
