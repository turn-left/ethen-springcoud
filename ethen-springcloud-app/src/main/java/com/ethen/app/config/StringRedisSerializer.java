package com.ethen.app.config;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.Assert;

import java.nio.charset.Charset;


/**
 * 重写StringRedisSerializer
 * <p>
 * 使用StringRedisSerializer做key的序列化时，StringRedisSerializer的泛型指定的是String，
 * 传其他对象就会报类型转换错误，在使用@Cacheable注解是key属性就只能传String进来。把这个序列化方式重写了，将泛型改成Object
 * ————————————————
 * 版权声明：本文为CSDN博主「Full Stack Developme」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/lizhengyu891231/article/details/88598781
 */
public class StringRedisSerializer implements RedisSerializer<Object> {
    private final Charset charset;


    public StringRedisSerializer() {
        this(Charset.defaultCharset());
    }

    public StringRedisSerializer(Charset charset) {
        Assert.notNull(charset, "charset must not be null.");
        this.charset = charset;
    }

    @Override
    public byte[] serialize(Object obj) throws SerializationException {
        if (obj == null) return null;
        String result = JSON.toJSONString(obj).replaceAll("\"", "");
        return result.getBytes(charset);
    }


    @Override
    public String deserialize(byte[] bytes) throws SerializationException {
        return bytes == null ? null : new String(bytes, charset);
    }
}
