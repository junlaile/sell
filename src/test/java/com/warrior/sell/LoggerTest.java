package com.warrior.sell;

//import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//可以使用 lombok 依赖 使用时要导入 lombok 插件
//@Slf4j
public class LoggerTest {
    //选择 org.slf4j 包下的Logger
    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void demo1() {
        String name = "jun", password = "123";
        logger.trace("trace---->");
        logger.debug("debug----->");
        logger.info("info----->");
        // 使用占位符可以使用字符串拼接
        logger.warn("warn----->name = {},password = {}", name, password);
        logger.error("error----->");
    }
}
