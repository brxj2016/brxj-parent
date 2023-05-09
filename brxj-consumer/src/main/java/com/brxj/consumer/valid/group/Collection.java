package com.brxj.consumer.valid.group;

import jakarta.validation.groups.Default;

/**
 * 集合验证
 *
 * @author qianrui
 */
public interface Collection extends Default {

    /**
     * 至少一项接口
     *
     * @author qianrui
     */
    interface LeastOne extends Collection {
    }
}
