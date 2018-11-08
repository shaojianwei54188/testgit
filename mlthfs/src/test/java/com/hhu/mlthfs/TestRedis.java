//package com.hhu.mlthfs;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class TestRedis {
//
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    @Test
//    public void test() throws Exception{
//
//        List<String> list =new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("v");
//        stringRedisTemplate.opsForValue().set("abc", "123");
//        stringRedisTemplate.opsForList().leftPushAll("qq",list); // 向redis存入List
//        stringRedisTemplate.opsForList().range("qwe",0,-1).forEach(value ->{
//            System.out.println(value);
//        });
//    }
//}
