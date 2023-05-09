package com.brxj.base.entity;

import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * 基础实体类
 *
 * @author qianrui
 */
@NoArgsConstructor
public abstract class BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -7204746826650075765L;
}
