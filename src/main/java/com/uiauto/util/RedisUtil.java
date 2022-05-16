package com.uiauto.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    @Autowired
    private StringRedisTemplate redisTemplate;
    //设置String类型key值的过期时间，单位为秒
    public  void expireString(String key, long timeout) {
        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }
    //获取String类型key值的过期时间，单位为秒
    public  long ttlString(String key) {
        return redisTemplate.getExpire(key);
    }
    //设置String类型的key
    public void setString(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }
    //设置String类型的key和key的过期时间
    public void setString(String key, String value, long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }
    //获取String类型的key
    public String getString(String key) {
        return (String)redisTemplate.opsForValue().get(key);
    }
    //删除String类型的key
    public void delString(String key) {
        redisTemplate.delete(key);
    }
    //将String类型的key值增加指定的常量
    public long incrString(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }
    //返回指定pattern类型的String值
    public Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }
    //设置hash值
    public void hset(String key, String field, Object value) {
        redisTemplate.opsForHash().put(key, field, value);
    }
    //获取hash价值对中的值
    public String hget(String key, String field) {
        return (String) redisTemplate.opsForHash().get(key, field);
    }
    //删除hash键值对
    public void hdel(String key, Object... fields) {
        redisTemplate.opsForHash().delete(key, fields);
    }
    //获取键值hash键值对
    public Map<Object, Object> hgetall(String key) {
        return redisTemplate.opsForHash().entries(key);
    }
    //list中表头插入
    public long lpush(String key, String value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }
    //list中表头移除值并返回
    public String lpop(String key) {
        return (String)redisTemplate.opsForList().leftPop(key);
    }
    //list表尾插入
    public long rpush(String key, String value) {
        return redisTemplate.opsForList().rightPush(key, value);
    }
}
