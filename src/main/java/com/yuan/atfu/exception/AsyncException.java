package com.yuan.atfu.exception;

import lombok.Data;

/**
 * @author David Hong
 * @version 1.0
 * @description 异步异常类
 */
@Data
public class AsyncException extends Exception {

    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;

}
