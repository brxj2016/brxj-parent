package com.brxj.base.service;

import com.brxj.base.entity.BaseEntity;
import com.brxj.base.exception.ProviderException;

/**
 * DTO服务层接口
 *
 * @author qianrui
 */
public interface DtoService<T extends BaseEntity, D extends T> extends BaseService<T> {

    /**
     * 根据id查询DTO
     *
     * @param id id
     *
     * @return DTO详情
     *
     * @throws ProviderException 异常对象
     */
    D selectDto(Long id) throws ProviderException;

    /**
     * 新增DTO
     *
     * @param dto dto对象
     *
     * @return 新增的实体数据id
     *
     * @throws ProviderException 异常对象
     */
    Long insertDto(D dto) throws ProviderException;

    /**
     * 更新DTO
     *
     * @param dto dto对象
     *
     * @return 更新的实体对象数量
     *
     * @throws ProviderException 异常对象
     */
    Long updateDto(D dto) throws ProviderException;
}
