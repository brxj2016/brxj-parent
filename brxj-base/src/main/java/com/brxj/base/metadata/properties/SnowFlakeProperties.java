package com.brxj.base.metadata.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 雪花算法配置
 *
 * @author qianrui
 */
@Getter
@Setter
@NoArgsConstructor
@Component
@ConfigurationProperties("brxj.snowflake")
public final class SnowFlakeProperties {

    /** 数据中心id */
    private Long dataCenterId = 0L;

    /** 机器id */
    private Long machineId = 0L;
}
