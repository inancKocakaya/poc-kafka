package com.kocakaya.pockafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, HelloWorldResponse> kafkaTemplate;

    public void send(String topic, String payload) {
        var helloWorldResponse = HelloWorldResponse.newBuilder()
                .setGreeting(payload)
                .setDescription("desc from ink")
                .build();
        kafkaTemplate.send(topic, payload, helloWorldResponse);
    }
}
