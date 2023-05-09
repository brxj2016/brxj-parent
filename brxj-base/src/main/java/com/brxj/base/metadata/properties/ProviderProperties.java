package com.brxj.base.metadata.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 提供者配置
 *
 * @author qianrui
 */
@Getter
@Setter
@NoArgsConstructor
@Component
@ConfigurationProperties("brxj.provider")
public final class ProviderProperties {

    /** 客户端 */
    private String client;

    /** 远程客户端 */
    private String remoteClient;

    /** cloud客户端 */
    private String cloudClient;

    /** nacos客户端 */
    private String nacosClient;

    /** feign客户端 */
    private String feignClient;

    /** dubbo客户端 */
    private String dubboClient;

    /** 服务客户端 */
    private String[] serverClient;
}
