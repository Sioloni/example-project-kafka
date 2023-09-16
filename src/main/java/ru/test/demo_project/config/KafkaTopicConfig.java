package ru.test.demo_project.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topics.create-language-topic}")
    private String topicName;


    @Bean
    public NewTopic newTopic() {
        return new NewTopic
                (
                        topicName,
                        1,
                        (short) 1
                );
    }
}
