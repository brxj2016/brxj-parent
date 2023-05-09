package com.brxj.provider.ibatis;

import com.brxj.base.entity.BaseEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * 只读映射接口
 *
 * @author qianrui
 */
public interface ReadOnlyMapper<T extends BaseEntity> extends BaseMapper<T> {

    /**
     * 根据map条件查询数量
     *
     * @param map 条件
     *
     * @return 数量
     */
    Long countByMap(@Param("map") Map<String, Object> map);

    /**
     * 根据map条件查询分页数据
     *
     * @param map      条件
     * @param pageable 分页器
     *
     * @return 数据列表
     */
    List<T> selectPageByMap(@Param("map") Map<String, Object> map, @Param("page") Pageable pageable);

    /**
     * 根据map条件查询列表数据
     *
     * @param map 条件
     *
     * @return 数据列表
     */
    List<T> selectListByMap(@Param("map") Map<String, Object> map);

    /**
     * 根据id查询详情
     *
     * @param id id
     *
     * @return 详情
     */
    T selectOne(@Param("id") Long id);
}
