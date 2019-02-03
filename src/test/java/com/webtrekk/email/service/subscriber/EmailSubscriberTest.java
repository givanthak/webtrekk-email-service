package com.webtrekk.email.service.subscriber;

import com.webtrekk.email.service.avro.Email;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class EmailSubscriberTest {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmailSubscriberTest.class);

    private static String RECEIVER_TOPIC = "email.service.topic";

    @Autowired
    private EmailSubscriber subscriber;

    private KafkaTemplate<String, Object> template;

    @Autowired
    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

    @ClassRule
    public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, "email.service.topic");


    @Before
    public void setUp() throws Exception {
        // set up the Kafka producer properties
        Map<String, Object> senderProperties =
                KafkaTestUtils.senderProps(
                        embeddedKafka.getBrokersAsString());

        // create a Kafka producer factory
        ProducerFactory<String, Object> producerFactory =
                new DefaultKafkaProducerFactory<String, Object>(
                        senderProperties);

        // create a Kafka template
        template = new KafkaTemplate<String, Object>(producerFactory);
        // set the default topic to send to
        template.setDefaultTopic(RECEIVER_TOPIC);

        // wait until the partitions are assigned
        for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry
                .getListenerContainers()) {
            ContainerTestUtils.waitForAssignment(messageListenerContainer,
                    embeddedKafka.getPartitionsPerTopic());
        }
    }

    @Test
    public void testReceive() throws Exception {
        // send the message
        Email email = Email.newBuilder()
                .setFrom("prathap.givantha@live.com")
                .setTo("prathap.givantha@live.co")
                .setSubject("Test")
                .setBody("Test")
                .build();
        LOGGER.debug("test-sender sent message='{}'", email);

        subscriber.consume(email);

    }

}
