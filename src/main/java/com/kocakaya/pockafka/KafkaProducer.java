package com.kocakaya.pockafka;

import com.kocakaya.pockafka.serialization.HelloWorldSerializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

import java.util.Properties;

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
