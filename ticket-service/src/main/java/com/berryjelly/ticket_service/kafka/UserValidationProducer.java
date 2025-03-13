package com.berryjelly.ticket_service.kafka;

import model.messaging.kafkamodels.UserValidationRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UserValidationProducer {

    private final KafkaTemplate<String, UserValidationRequest> template;

    public UserValidationProducer(KafkaTemplate<String, UserValidationRequest> template) {
        this.template = template;
    }

    public void sendUserValidationRequest(UserValidationRequest request){
        CompletableFuture<SendResult<String, UserValidationRequest>> future = template.send("user-validation-requests", request);
        future.whenComplete((result, ex)-> {
           if (ex == null){
               System.out.println("Sent message[" + request.getUserIds() + "] with offset=["
                       + result.getRecordMetadata().offset() + "]");
           } else {
               System.out.println("Unable to send message=[" + request.getRequestId() + "] due to: " + ex.getMessage());
           }
        });
    }
}
