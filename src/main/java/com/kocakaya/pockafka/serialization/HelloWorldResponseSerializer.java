package com.kocakaya.pockafka.serialization;

import com.kocakaya.pockafka.HelloWorldResponse;
import org.apache.kafka.common.serialization.Serializer;

public class HelloWorldSerializer implements Serializer<HelloWorldResponse> {

    @Override
    public byte[] serialize(String topic, HelloWorldResponse helloWorldResponse) {
        return helloWorldResponse.toByteArray();
    }
}
