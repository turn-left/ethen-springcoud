package com.ethen.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 定时向卡夫卡发送数据
 */
@Component
public class KafkaProducerTask {

    @Autowired
    KafkaSender<String> kafkaSender;

    /**
     * 每隔5秒钟向topic ethen-springcloud-topic-01 中发送一条消息
     */
    @Scheduled(cron = "${send.msg.cron}")
    public void sendMsgTask() {
        String seed = "ethen-msg-%s";
        String msg = String.format(seed, UUID.randomUUID().toString().replaceAll("-", ""));
        kafkaSender.send(msg);
    }
}
