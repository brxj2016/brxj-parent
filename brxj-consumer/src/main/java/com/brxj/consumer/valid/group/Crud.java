package com.brxj.consumer.valid.group;

import jakarta.validation.groups.Default;

/**
 * 增删改查分组接口
 *
 * @author qianrui
 */
public interface Crud extends Default {

    /**
     * 查询分组接口
     *
     * @author qianrui
     */
    interface Query extends Crud {
    }

    /**
     * 新增分组接口
     *
     * @author qianrui
     */
    interface Create extends Crud {
    }

    /**
     * 编辑分组接口
     *
     * @author qianrui
     */
    interface Update extends Crud {
    }

    /**
     * 删除分组接口
     *
     * @author qianrui
     */
    interface Delete extends Crud {
    }
}