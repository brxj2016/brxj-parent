package com.brxj.base.service;

import com.brxj.base.entity.BaseEntity;
import com.brxj.base.exception.ProviderException;

import java.util.List;

/**
 * 批量服务层接口
 *
 * @author qianrui
 */
public interface BatchService<T extends BaseEntity> extends BaseService<T> {

    /**
     * 批量新增
     *
     * @param list 实体列表
     *
     * @return 新增的条数
     *
     * @throws ProviderException 异常对象
     */
    Long batchInsert(List<T> list) throws ProviderException;

    /**
     * 批量删除
     *
     * @param idList id列表
     *
     * @return 删除的条数
     *
     * @throws ProviderException 异常对象
     */
    Long batchDelete(List<Long> idList) throws ProviderException;

    /**
     * 批量逻辑删除
     *
     * @param idList id列表
     *
     * @return 逻辑删除的条数
     *
     * @throws ProviderException 异常对象
     */
    Long batchLogicDelete(List<Long> idList) throws ProviderException;
}
