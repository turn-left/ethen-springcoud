package com.ethen.app.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * 采用fastjson框架作为redis序列化器
 *
 * @see {https://blog.csdn.net/lizhengyu891231/article/details/88598781}
 */
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {
    public static final Charset DEFAULT_CHARSET = Charset.defaultCharset();


    // fixme -> 待改进通用性
    private Class<T> clazz;

    public FastJsonRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T obj) throws SerializationException {
        if (obj == null)
            return new byte[0];
        else
            return JSON.toJSONString(obj, SerializerFeature.WRITE_MAP_NULL_FEATURES).getBytes(DEFAULT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0)
            return null;
        else {
            String str = new String(bytes, DEFAULT_CHARSET);
            return JSON.parseObject(str, clazz);
        }
    }
}
