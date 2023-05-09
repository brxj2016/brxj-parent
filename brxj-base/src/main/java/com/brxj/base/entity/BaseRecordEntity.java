package com.brxj.base.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 记录实体类
 *
 * @author qianrui
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public abstract class BaseRecordEntity extends BaseStandardEntity {

    /** 创建用户id */
    @Schema(description = "创建用户id")
    protected Long createUserId;

    /** 更新用户id */
    @Schema(description = "更新用户id")
    protected Long updateUserId;

    /** 创建用户名 */
    @Schema(description = "创建用户名")
    protected String createUserName;

    /** 更新用户名 */
    @Schema(description = "更新用户名")
    protected String updateUserName;
}
