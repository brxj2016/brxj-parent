package com.brxj.provider.exception;

import com.brxj.base.exception.ProviderException;

import java.io.Serial;

/**
 * 消费者服务异常
 *
 * @author qianrui
 */
public final class ProviderServiceException extends ProviderException {

    /** 默认提供者异常 */
    public static final ProviderException DEFAULT = of();
    @Serial
    private static final long serialVersionUID = -5920284733488595483L;

    public ProviderServiceException() {
        super();
    }

    public ProviderServiceException(String cause) {
        super(cause);
    }

    /**
     * 创建异常对象
     *
     * @return {@link ProviderException} 提供者异常对象
     */
    public static ProviderException of() {
        return new ProviderServiceException();
    }

    /**
     * 创建异常对象
     *
     * @param cause 原因
     *
     * @return {@link ProviderException} 提供者异常对象
     */
    public static ProviderException of(final String cause) {
        return new ProviderServiceException(cause);
    }
}
