package com.brxj.base.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 标准实体类
 *
 * @author qianrui
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public abstract class BaseStandardEntity extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -4033811974140419084L;

    /** id */
    @Schema(description = "id")
    protected Long id;

    /** 创建时间 */
    @Schema(description = "创建时间")
    protected LocalDateTime createTime;

    /** 修改时间 */
    @Schema(description = "更新时间")
    protected LocalDateTime updateTime;

    /** 是否删除 */
    @JsonIgnore
    protected Boolean deleted;
}
