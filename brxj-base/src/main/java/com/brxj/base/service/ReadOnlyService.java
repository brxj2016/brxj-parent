package com.brxj.base.service;

import com.brxj.base.entity.BaseEntity;
import com.brxj.base.exception.ProviderException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * 只读服务层接口
 *
 * @author qianrui
 */
public interface ReadOnlyService<T extends BaseEntity> extends BaseService<T> {

    /**
     * 根据map条件查询分页数据
     *
     * @param map      条件
     * @param pageable 分页器
     *
     * @return 数据列表
     *
     * @throws ProviderException 异常对象
     */
    Page<T> selectPageByMap(Map<String, Object> map, Pageable pageable) throws ProviderException;

    /**
     * 根据map条件查询列表数据
     *
     * @param map 条件
     *
     * @return 数据列表
     *
     * @throws ProviderException 异常对象
     */
    List<T> selectListByMap(Map<String, Object> map) throws ProviderException;

    /**
     * 根据id查询详情
     *
     * @param id id
     *
     * @return 详情
     *
     * @throws ProviderException 异常对象
     */
    T selectOne(Long id) throws ProviderException;
}
