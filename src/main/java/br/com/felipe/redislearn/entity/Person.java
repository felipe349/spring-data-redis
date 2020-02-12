package br.com.felipe.redislearn.entity;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("Person")
public class Person implements Serializable {
    public String id;
    public String name;
    public int age;
}
