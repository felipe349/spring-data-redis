package br.com.felipe.redislearn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class AppConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisConf = new RedisStandaloneConfiguration();
        redisConf.setHostName("redis-11347.c44.us-east-1-2.ec2.cloud.redislabs.com");
        redisConf.setPort(11347);
        redisConf.setPassword("wNqTPzVRPJnLYLlrt47VBcXCBXPG2PdD");
        return new JedisConnectionFactory(redisConf);
    }

    @Bean
    public RedisTemplate<String, Integer> redisTemplate() {
        RedisTemplate<String, Integer> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.afterPropertiesSet();
        ListOperations<String, Integer> listOperations = template.opsForList();
        listOperations.trim("test", 0, 2);
        return template;
    }


}
