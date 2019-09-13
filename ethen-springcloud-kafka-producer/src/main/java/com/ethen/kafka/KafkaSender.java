package com.ethen.kafka;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.Nullable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;

/**
 * 卡夫卡消息发送spring-boot整合
 *
 * @param <T>
 * @see {https://www.cnblogs.com/softmax/p/9414726.html}
 */
@Component
public class KafkaSender<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaSender.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * 发送消息的方法
     *
     * @param obj
     */
    public void send(T obj) {
        String jsonObj = JSON.toJSONString(obj);
        LOGGER.info("send message to kafka msg={}", jsonObj);
        //发送消息
        ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(TopicConstant.ETHEN_SPRING_CLOUD_TOPIC_01, jsonObj);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {

            @Override
            public void onFailure(Throwable throwable) {
                LOGGER.info("Producer => send msg failed {}", throwable.getMessage());
                //fixme 方法含义
            }

            @Override
            public void onSuccess(@Nullable SendResult<String, Object> stringObjectSendResult) {
                //fixme 方法含义
                LOGGER.info("Producer => send msg success {}", stringObjectSendResult.toString());
                //todo 处理业务
            }
        });
    }


}
