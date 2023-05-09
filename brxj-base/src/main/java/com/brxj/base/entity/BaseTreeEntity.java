package com.brxj.base.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 树形实体类
 *
 * @author qianrui
 */
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public abstract class BaseTreeEntity extends BaseRecordEntity {

    /** 父id */
    @Schema(description = "父id")
    protected Long pid;

    /** id路径 */
    @Schema(description = "id路径")
    protected String idPath;

    /** 层级 */
    @Schema(description = "层级")
    protected Integer level;

    /** 是否叶子节点 */
    @Schema(description = "是否叶子节点")
    protected Boolean leaf;

    /** 标识 */
    @Schema(description = "标识")
    protected String sign;
}
