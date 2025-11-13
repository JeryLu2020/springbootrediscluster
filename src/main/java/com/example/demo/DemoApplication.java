package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import io.lettuce.core.RedisURI;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.async.RedisAdvancedClusterAsyncCommands;

import java.util.concurrent.ExecutionException;

import io.lettuce.core.cluster.ClusterClientOptions;
import io.lettuce.core.SslOptions;


/**
 * Spring Boot HelloWorld 案例
 *
 * Created by bysocket on 16/4/26.
 */
@RestController
public class DemoApplication  {
    RedisURI redisUri = RedisURI.Builder.redis("yuawamr.eastasia.redis.azure.net", 10000)
            .withPassword("")
            .withSsl(true)
            .withVerifyPeer(false)
            .build();

    @RequestMapping("/")
    public String sayHello() {
        System.out.println("start1111");

        try(RedisClusterClient clusterClient = RedisClusterClient.create(redisUri)) {

            StatefulRedisClusterConnection<String, String> connection = clusterClient.connect();
            RedisAdvancedClusterAsyncCommands<String, String> asyncCommands = connection.async();

            asyncCommands.set("jery", "lu").get();
            System.out.println(asyncCommands.get("jery").get());

            connection.close();
            clusterClient.shutdown();

            return "Hello,World!";
        }catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
