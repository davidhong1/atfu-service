package com.yuan.atfu.exception;

import lombok.Data;

@Data
public class AsyncException extends Exception {

    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;

}
