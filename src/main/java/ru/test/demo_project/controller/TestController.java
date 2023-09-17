package ru.test.demo_project.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.demo_project.model.Message;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/test")
public class TestController {
    private final KafkaTemplate<String, String> kafkaTemplate;


    @PostMapping
    public void publish(@RequestBody Message entity){
        kafkaTemplate.send("test-topic", entity.message());
    }


}
