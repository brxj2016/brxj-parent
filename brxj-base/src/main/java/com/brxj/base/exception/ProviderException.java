package com.brxj.base.exception;

import lombok.Getter;

import java.io.Serial;

/**
 * 提供者异常
 *
 * @author qianrui
 */
public class ProviderException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 5829593007545418711L;

    /** 消息 */
    @Getter
    private final String message;

    protected ProviderException() {
        this("请检查服务后重试!");
    }

    protected ProviderException(String cause) {
        super("提供者异常", new Throwable(cause));

        this.message = cause;
    }
}
