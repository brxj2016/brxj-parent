package com.brxj.consumer.rest;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * REST结果集类
 *
 * @author qianrui
 */
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public final class RestResult<T> implements Serializable {

    /** 默认结果集 */
    public static final RestResult<String> DEFAULT = success("success");
    /** 异常结果集 */
    public static final RestResult<String> EXCEPTION = error("应用异常", "服务器内部错误");
    /** 统计前缀 */
    public static final String TOTAL_PREFIX = "共查询/新增/更新/删除了";
    /** 统计后缀 */
    public static final String TOTAL_SUFFIX = "条数据";
    @Serial
    private static final long serialVersionUID = -3531433205518879035L;
    /** 状态 */
    private final boolean status;

    /** 标题 */
    private final String title;

    /** 消息 */
    private final String message;

    /** 数据 */
    private final T data;

    /**
     * 成功结果集
     *
     * @param data 数据
     *
     * @return {@link RestResult} 成功结果集
     */
    public static <T> RestResult<T> success(final T data) {
        return success(data, null, null);
    }

    /**
     * 成功结果集
     *
     * @param data    数据
     * @param title   标题
     * @param message 消息
     *
     * @return {@link RestResult} 成功结果集
     */
    public static <T> RestResult<T> success(final T data, final String title, final String message) {
        return new RestResult<>(true, title, message, data);
    }

    /**
     * 失败结果集
     *
     * @param title   标题
     * @param message 消息
     *
     * @return {@link RestResult} 失败结果集
     */
    public static RestResult<String> error(final String title, final String message) {
        return error(title, message, null);
    }

    /**
     * 失败结果集
     *
     * @param title   标题
     * @param message 消息
     * @param data    数据
     *
     * @return {@link RestResult} 失败结果集
     */
    public static <T> RestResult<T> error(final String title, final String message, final T data) {
        return new RestResult<>(false, title, message, data);
    }

    /**
     * 统计结果集
     *
     * @param count 计数
     *
     * @return {@link RestResult} 统计结果集
     *
     * @see RestResult#TOTAL_PREFIX
     * @see RestResult#TOTAL_SUFFIX
     */
    public static RestResult<String> total(final long count) {
        return total(count, TOTAL_PREFIX, TOTAL_SUFFIX);
    }

    /**
     * 统计结果集
     *
     * @param count  计数
     * @param prefix 前缀
     * @param suffix 后缀
     *
     * @return {@link RestResult} 统计结果集
     */
    public static RestResult<String> total(final long count, final String prefix, final String suffix) {
        return success(prefix + count + suffix);
    }
}
