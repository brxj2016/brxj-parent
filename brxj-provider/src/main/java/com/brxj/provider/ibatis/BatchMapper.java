package com.brxj.provider.ibatis;

import com.brxj.base.entity.BaseEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 批量映射接口
 *
 * @author qianrui
 */
public interface BatchMapper<T extends BaseEntity> extends BaseMapper<T> {

    /**
     * 批量新增
     *
     * @param list 实体列表
     *
     * @return 新增的条数
     */
    Long batchInsert(@Param("list") List<T> list);

    /**
     * 批量删除
     *
     * @param idList id列表
     *
     * @return 删除的条数
     */
    Long batchDelete(@Param("list") List<Long> idList);

    /**
     * 批量逻辑删除
     *
     * @param idList id列表
     *
     * @return 逻辑删除的条数
     */
    Long batchLogicDelete(@Param("list") List<Long> idList);
}
