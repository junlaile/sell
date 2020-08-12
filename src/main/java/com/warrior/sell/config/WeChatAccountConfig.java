package com.warrior.sell.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author jun
 * @data 2020/8/11
 */
@Configuration
@PropertySource("classpath:application.properties")
@Data
public class WeChatAccountConfig {
    @Value("${wechat.mpAppId}")
    private String mpAppId;
    @Value("${wechat.mpSecret}")
    private String mpSecret;
    @Value("${wechat.mchId}")
    private String mchId;
    @Value("${wechat.mchKey}")
    private String mchKey;
    @Value("${wechat.keyPath}")
    private String keyPath;
}
