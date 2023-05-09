package com.brxj.base.service;

import com.brxj.base.entity.BaseEntity;
import com.brxj.base.exception.ProviderException;

/**
 * 可变服务层接口
 *
 * @author qianrui
 */
public interface VariableService<T extends BaseEntity> extends BaseService<T> {

    /**
     * 新增
     *
     * @param entity 实体对象
     *
     * @return 新增的数据id
     *
     * @throws ProviderException 异常对象
     */
    Long insert(T entity) throws ProviderException;

    /**
     * 更新
     *
     * @param entity 实体对象
     * @param id     id
     *
     * @return 更新的数据数量
     *
     * @throws ProviderException 异常对象
     */
    Long update(T entity, Long id) throws ProviderException;

    /**
     * 删除
     *
     * @param id id
     *
     * @return 删除的数据数量
     *
     * @throws ProviderException 异常对象
     */
    Long delete(Long id) throws ProviderException;

    /**
     * 逻辑删除
     *
     * @param id id
     *
     * @return 逻辑删除的数据数量
     *
     * @throws ProviderException 异常对象
     */
    Long logicDelete(Long id) throws ProviderException;
}
