package com.ethen;

import com.ethen.app.EthenSpringcloudAppApplication;
import com.ethen.app.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EthenSpringcloudAppApplication.class)
public class EthenSpringcloudAppApplicationTests {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    RedisUtil redis;

    @Test
    public void contextLoads() {
    }


    @Test
    public void testDeserialization() {
        String key = "user_list::SimpleKey [123,268629]";
        Object value = redis.get(key);
        System.err.println(value);

        List valueList = (List) redisTemplate.opsForValue().get(key);
        System.err.println();
    }

}
