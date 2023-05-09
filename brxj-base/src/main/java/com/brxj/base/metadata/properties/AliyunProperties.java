package com.brxj.base.metadata.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 阿里云配置
 *
 * @author qianrui
 */
@Getter
@Setter
@NoArgsConstructor
@Component
@ConfigurationProperties("brxj.aliyun")
public final class AliyunProperties {

    @Getter
    @Setter
    @NoArgsConstructor
    @Component
    @ConfigurationProperties("brxj.aliyun.access-key")
    public static final class AliyunAccessKeyProperties {

        /** accessKeyId */
        private String id;

        /** accessKeySecret */
        private String secret;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @Component
    @ConfigurationProperties("brxj.aliyun.oss")
    public static final class AliyunOssProperties {

        /** endpoint */
        private String endpoint;

        /** bucket */
        private String bucket;
    }
}
