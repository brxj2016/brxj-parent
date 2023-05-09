package com.brxj.consumer.exception;

import com.brxj.base.exception.ProviderException;
import com.brxj.consumer.rest.RestException;
import com.brxj.consumer.rest.RestMessage;

/**
 * 异常解析器
 *
 * @author qianrui
 */
public final class ExceptionResolver {

    private ExceptionResolver() {
        throw new AssertionError("无法构造 com.brxj.consumer.exception.ExceptionResolver 实例对象");
    }

    /**
     * 解析异常
     *
     * @param restMessage 异常消息对象
     * @param e           异常对象
     *
     * @return {@link RuntimeException} 解析后的异常对象
     */
    public static RuntimeException parse(final RestMessage restMessage, final Exception e) {
        /* 提供者异常 */
        if (e instanceof ProviderException providerException) {
            return restMessage.buildException(providerException.getMessage());
        }

        /* 统一异常 */
        if (e instanceof RestException restException) {
            return restException;
        }

        /* 其他异常 */
        return restMessage.buildException();
    }
}
