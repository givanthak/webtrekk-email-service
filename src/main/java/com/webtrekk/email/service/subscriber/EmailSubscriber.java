package com.webtrekk.email.service.subscriber;

import com.webtrekk.email.service.avro.Email;
import com.webtrekk.email.service.configuration.ApplicationConstant;
import com.webtrekk.email.service.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class EmailSubscriber {


    private final Logger LOGGER = LoggerFactory.getLogger(EmailSubscriber.class);

    @Autowired
    EmailService emailService;

    @KafkaListener(topics = ApplicationConstant.TOPIC_NAME, groupId = "group_id")
    public void consume(@Payload Email email) {

        LOGGER.info("Email to {} processing started.", email.getTo());
        emailService.sendEmail(email);

    }
}
