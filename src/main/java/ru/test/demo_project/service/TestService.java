package ru.test.demo_project.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service

public class TestService {


    @KafkaListener
            (
                    topics = "test-topic",
                    groupId = "groupId"
            )
    void listener(String data){
        System.out.println("Listener " + data);
    }
}
