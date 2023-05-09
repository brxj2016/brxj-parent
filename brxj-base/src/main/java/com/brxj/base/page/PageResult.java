package com.brxj.base.page;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serial;
import java.util.List;

/**
 * 分页结果类
 *
 * @author qianrui
 */
public final class PageResult<T> extends PageImpl<T> {

    @Serial
    private static final long serialVersionUID = -8069864633916640208L;

    private PageResult() {
        super(List.of());
    }

    private PageResult(List<T> content) {
        super(content);
    }

    private PageResult(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    /**
     * 空分页结果
     *
     * @return {@link PageResult} 空分页结果
     */
    public static <T> PageResult<T> empty() {
        return new PageResult<>(List.of());
    }

    /**
     * 空分页结果
     *
     * @param pageable 分页器
     *
     * @return {@link PageResult} 空分页结果
     */
    public static <T> PageResult<T> empty(final Pageable pageable) {
        return new PageResult<>(List.of(), pageable, 0L);
    }

    /**
     * 分页结果
     *
     * @param list 数据列表
     *
     * @return {@link PageResult} 分页结果
     */
    public static <T> PageResult<T> result(final List<T> list) {
        return new PageResult<>(list);
    }

    /**
     * 分页结果
     *
     * @param list     数据列表
     * @param pageable 分页器
     * @param total    数据总条数
     *
     * @return {@link PageResult} 分页结果
     */
    public static <T> PageResult<T> result(final List<T> list, final Pageable pageable, final long total) {
        return new PageResult<>(list, pageable, total);
    }
}