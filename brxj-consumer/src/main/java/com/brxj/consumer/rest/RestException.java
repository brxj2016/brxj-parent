package com.brxj.consumer.rest;

import java.io.Serial;

/**
 * REST异常类
 *
 * @author qianrui
 */
public final class RestException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -3960803068851403927L;

    /**
     * 消息对象
     *
     * @see RestMessage
     */
    public final RestMessage restMessage;

    /** 原因 */
    public final String cause;

    RestException(RestMessage message) {
        this(message, message.getMessage());
    }

    RestException(RestMessage message, String cause) {
        super(message.getMessage(), new RestThrowableException(cause));

        this.restMessage = message;
        this.cause = cause;
    }

    /**
     * 统一异常原因类
     *
     * @author qianrui
     */
    static final class RestThrowableException extends Throwable {

        @Serial
        private static final long serialVersionUID = 242511003970277258L;

        public RestThrowableException(String cause) {
            super(cause);
        }
    }
}
