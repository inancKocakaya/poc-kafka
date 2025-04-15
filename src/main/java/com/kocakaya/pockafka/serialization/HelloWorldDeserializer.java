package com.kocakaya.pockafka.serialization;

import com.google.protobuf.InvalidProtocolBufferException;
import com.kocakaya.pockafka.HelloWorldResponse;
import org.apache.kafka.common.serialization.Deserializer;

public class HelloWorldDeserializer implements Deserializer<HelloWorldResponse> {

    @Override
    public HelloWorldResponse deserialize(String topic, byte[] bytes) {
        try {
            return HelloWorldResponse.parseFrom(bytes);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }
    }
}
