package com.berryjelly.ticket_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic userValidationRequest(){
        return new NewTopic("user-validation-requests", 3, (short) 1);
    }

    @Bean
    public NewTopic userValidationResponse(){
        return new NewTopic("user-validation-responses", 3, (short) 1);
    }
}
