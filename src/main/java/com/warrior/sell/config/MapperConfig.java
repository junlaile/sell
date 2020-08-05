package com.warrior.sell.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.warrior.sell.mapper")
public class MapperConfig {
}
