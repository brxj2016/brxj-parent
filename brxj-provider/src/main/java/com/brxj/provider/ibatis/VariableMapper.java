package com.brxj.provider.ibatis;

import com.brxj.base.entity.BaseEntity;
import org.apache.ibatis.annotations.Param;

/**
 * 可变映射接口
 *
 * @author qianrui
 */
public interface VariableMapper<T extends BaseEntity> extends BaseMapper<T> {

    /**
     * 新增
     *
     * @param entity 实体对象
     *
     * @return 新增的条数
     */
    Long insert(@Param("et") T entity);

    /**
     * 更新
     *
     * @param entity 实体对象
     *
     * @return 更新的条数
     */
    Long update(@Param("et") T entity);

    /**
     * 删除
     *
     * @param id id
     *
     * @return 删除的条数
     */
    Long delete(@Param("id") Long id);

    /**
     * 逻辑删除
     *
     * @param id id
     *
     * @return 逻辑删除的条数
     */
    Long logicDelete(@Param("id") Long id);
}
