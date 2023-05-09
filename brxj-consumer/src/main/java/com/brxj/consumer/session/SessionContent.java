package com.brxj.consumer.session;

import java.io.Serializable;

/**
 * 会话内容
 *
 * @author qianrui
 */
public interface SessionContent extends Serializable {

    /**
     * 获取会话内容名称
     *
     * @return 会话内容名称
     */
    String name();
}
