package com.kocakaya.pockafka;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
@Slf4j
@Getter
public class KafkaConsumer {

    private CountDownLatch latch = new CountDownLatch(1);
    private String payload;

    @KafkaListener(topics = "test-ink-topic", groupId = "ink")
    public void receive(String message) {
        log.info("received payload='{}'", message);
        payload = message;
        latch.countDown();
    }
}
