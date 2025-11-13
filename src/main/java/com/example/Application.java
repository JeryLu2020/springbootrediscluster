package com.example;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import io.lettuce.core.cluster.RedisClusterClient;
//import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
//
//
//@SpringBootApplication
//public class Application implements CommandLineRunner {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
//
//    @Autowired
//    private StringRedisTemplate template;
//
//    public static void main(String[] args) {
//        SpringApplication.run(Application.class,args);
//    }
//
//    @Override
//    public void run(String... args) {
//        ValueOperations<String, String> ops = this.template.opsForValue();
//        String key = "testkey";
//        if(!this.template.hasKey(key)){
//            ops.set(key, "Hello World");
//            LOGGER.info("Add a key is done");
//        }
//        LOGGER.info("Return the value from the cache: {}", ops.get(key));
//    }
//
//}


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用启动类
 *
 * Created by bysocket on 16/4/26.
 */
// Spring Boot 应用的标识
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(Application.class,args);
    }
}
