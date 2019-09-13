package com.ethen.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


/**
 * 监听卡夫卡消息
 */
@Component
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    /**
     * 监听topic=ethen-springcloud-topic-01的消息
     *
     * @param record
     */
    @KafkaListener(topics = TopicConstant.ETHEN_SPRING_CLOUD_TOPIC_01)
    public void listen(ConsumerRecord<String, Object> record) {
        LOGGER.info("接收到的消息 => {}", record.value());
        LOGGER.info("========================================================");
        LOGGER.info("topic={},key={},value={},partition={},offset={}", record.topic(), record.key(), record.value(), record.partition(), record.offset());
        LOGGER.info("========================================================");
    }
}
