package com.kocakaya.pockafka;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootConfiguration
@EnableAutoConfiguration
public class TestConfiguration {

    @Bean
    public KafkaConsumer consumer() {
        return new KafkaConsumer();
    }

    @Bean
    public KafkaProducer producer(KafkaTemplate<String, String> kafkaTemplate) {
        return new KafkaProducer(kafkaTemplate);
    }
}
