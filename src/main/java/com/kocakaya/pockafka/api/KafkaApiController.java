package com.kocakaya.pockafka.api;

import com.kocakaya.pockafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KafkaApiController {

    private final KafkaProducer producer;

    @PostMapping("/kafka/message")
    public void addMessage(@RequestBody Payload payload) {
        producer.send("test-ink-topic", payload.message());
    }
}
