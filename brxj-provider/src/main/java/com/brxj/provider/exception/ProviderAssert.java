package com.brxj.provider.exception;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/**
 * 断言类
 *
 * @author qianrui
 */
public final class ProviderAssert {

    private ProviderAssert() {
        throw new AssertionError("无法构造 com.brxj.provider.exception.Assert 实例对象");
    }

    /**
     * 断言是否正确
     *
     * @param bool    布尔值
     * @param message 消息
     */
    public static void isTrue(final boolean bool, final String message) {
        execute(bool, message);
    }

    /**
     * 断言是否错误
     *
     * @param bool    布尔值
     * @param message 消息
     */
    public static void isFalse(final boolean bool, final String message) {
        execute(!bool, message);
    }

    /**
     * 断言是否为空
     *
     * @param obj     对象
     * @param message 消息
     */
    public static <T> void isNull(final T obj, final String message) {
        execute(Objects.isNull(obj), message);
    }

    /**
     * 断言是否非空
     *
     * @param obj     对象
     * @param message 消息
     */
    public static <T> void notNull(final T obj, final String message) {
        execute(Objects.nonNull(obj), message);
    }

    /**
     * 断言内容是否为空(字符串)
     *
     * @param str     字符串
     * @param message 消息
     */
    public static void isEmpty(final CharSequence str, final String message) {
        execute(Objects.isNull(str) || str.isEmpty(), message);
    }

    /**
     * 断言内容是否为空(集合)
     *
     * @param collection 集合
     * @param message    消息
     */
    public static <T> void isEmpty(final Collection<T> collection, final String message) {
        execute(Objects.isNull(collection) || collection.isEmpty(), message);
    }

    /**
     * 断言内容是否为空(数组)
     *
     * @param arr     数组
     * @param message 消息
     */
    public static <T> void isEmpty(final T[] arr, final String message) {
        execute(Objects.isNull(arr) || arr.length == 0, message);
    }

    /**
     * 断言内容是否非空(字符串)
     *
     * @param str     字符串
     * @param message 消息
     */
    public static void notEmpty(final CharSequence str, final String message) {
        execute(Objects.nonNull(str) && !str.isEmpty(), message);
    }

    /**
     * 断言内容是否非空(集合)
     *
     * @param collection 集合
     * @param message    消息
     */
    public static <T> void notEmpty(final Collection<T> collection, final String message) {
        execute(Objects.nonNull(collection) && !collection.isEmpty(), message);
    }

    /**
     * 断言内容是否非空(数组)
     *
     * @param arr     数组
     * @param message 消息
     */
    public static <T> void notEmpty(final T[] arr, final String message) {
        execute(Objects.nonNull(arr) && arr.length != 0, message);
    }

    /**
     * 断言内容是否空白(字符串)
     *
     * @param str     字符串
     * @param message 消息
     */
    public static void isBlack(final String str, final String message) {
        execute(Objects.isNull(str) || "".equals(str.trim()), message);
    }

    /**
     * 断言内容是否非空白(字符串)
     *
     * @param str     字符串
     * @param message 消息
     */
    public static void notBlack(final String str, final String message) {
        execute(Objects.nonNull(str) && !"".equals(str.trim()), message);
    }

    /**
     * 断言是否包含(集合)
     *
     * @param collection 集合
     * @param target     目标值
     * @param message    消息
     */
    public static <T> void isContain(final Collection<T> collection, final T target, final String message) {
        notNullExecute(collection.contains(target), message, collection);
    }

    /**
     * 断言是否包含(集合)
     *
     * @param collection 集合
     * @param target     目标集合
     * @param message    消息
     */
    public static <T> void isContain(final Collection<T> collection, final Collection<T> target, final String message) {
        notNullExecute(collection.containsAll(target), message, collection, target);
    }

    /**
     * 断言是否不包含(集合)
     *
     * @param collection 集合
     * @param target     目标值
     * @param message    消息
     */
    public static <T> void notContain(final Collection<T> collection, final T target, final String message) {
        notNullExecute(!collection.contains(target), message, collection);
    }

    /**
     * 断言是否不包含(集合)
     *
     * @param collection 集合
     * @param target     目标集合
     * @param message    消息
     */
    public static <T> void notContain(final Collection<T> collection, final Collection<T> target, final String message) {
        notNullExecute(!collection.containsAll(target), message, collection, target);
    }

    /**
     * 断言是否相等
     *
     * @param obj     对象
     * @param target  目标
     * @param message 消息
     */
    public static void equals(final Object obj, final Object target, final String message) {
        execute(Objects.equals(obj, target), message);
    }

    /**
     * 断言是否不相等
     *
     * @param obj     对象
     * @param target  目标
     * @param message 消息
     */
    public static void unequal(final Objects obj, final Object target, final String message) {
        execute(!Objects.equals(obj, target), message);
    }

    /**
     * 执行断言
     *
     * @param expression 表达式
     * @param message    消息
     */
    private static void execute(final boolean expression, final String message) {
        if (!expression) {
            throw ProviderServiceException.of(message);
        }
    }

    /**
     * 执行断言并检验参数是否为空
     *
     * @param expression 表达式
     * @param message    消息
     * @param params     参数
     */
    private static void notNullExecute(final boolean expression, final String message, final Object... params) {
        if (Arrays.asList(params).contains(null)) {
            throw new IllegalArgumentException("断言形参包含 null");
        }

        execute(expression, message);
    }
}
