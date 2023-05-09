package com.brxj.consumer.valid.group;

import jakarta.validation.groups.Default;

/**
 * 登录分组接口
 *
 * @author qianrui
 */
public interface Login extends Default {

    /**
     * 新增分组接口
     *
     * @author qianrui
     */
    interface LogOut extends Login {
    }

    /**
     * 注册分组接口
     *
     * @author qianrui
     */
    interface Register extends Login {
    }

    /**
     * 忘记密码分组接口
     *
     * @author qianrui
     */
    interface Forget extends Login {
    }
}