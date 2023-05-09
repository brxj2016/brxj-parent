package com.brxj.consumer.rest;

/**
 * REST消息接口
 *
 * @author qianrui
 */
public interface RestMessage {

    /**
     * 得到标题
     *
     * @return 标题
     */
    String getTitle();

    /**
     * 得到消息
     *
     * @return 消息
     */
    String getMessage();

    /**
     * 构建失败结果集
     *
     * @return {@link RestResult} 失败结果集
     */
    default RestResult<String> buildResult() {
        return buildResult(getMessage());
    }

    /**
     * 构建失败结果集
     *
     * @param cause 原因
     *
     * @return {@link RestResult} 失败结果集
     */
    default RestResult<String> buildResult(final String cause) {
        return RestResult.error(getTitle(), cause);
    }

    /**
     * 构建异常对象
     *
     * @return {@link RestException} 异常对象
     */
    default RestException buildException() {
        return new RestException(this);
    }

    /**
     * 构建异常对象
     *
     * @param cause 原因
     *
     * @return {@link RestException} 异常对象
     */
    default RestException buildException(final String cause) {
        return new RestException(this, cause);
    }
}
