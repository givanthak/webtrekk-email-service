package com.webtrekk.email.service.publisher;

import com.webtrekk.email.service.avro.Email;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.kafka.listener.config.ContainerProperties;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.springframework.kafka.test.assertj.KafkaConditions.key;
import static org.springframework.kafka.test.hamcrest.KafkaMatchers.hasValue;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class EmailPublisherTest {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(EmailPublisherTest.class);

	private static String SENDER_TOPIC = "email.service.topic";

	@Autowired
	private EmailPublisher publisher;

	private KafkaMessageListenerContainer<String, Email> container;

	private BlockingQueue<ConsumerRecord<String, Email>> records;

	@ClassRule
	public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, "email.service.topic");

	@Before
	public void setUp() throws Exception {
		// set up the Kafka consumer properties
		Map<String, Object> consumerProperties =
				KafkaTestUtils.consumerProps("sender", "false",
						embeddedKafka);

		// create a Kafka consumer factory
		DefaultKafkaConsumerFactory<String, Email> consumerFactory =
				new DefaultKafkaConsumerFactory<String, Email>(
						consumerProperties);

		// set the topic that needs to be consumed
		ContainerProperties containerProperties =
				new ContainerProperties(SENDER_TOPIC);

		// create a Kafka MessageListenerContainer
		container = new KafkaMessageListenerContainer<String, Email>(consumerFactory,
				containerProperties);

		// create a thread safe queue to store the received message
		records = new LinkedBlockingQueue<>();

		// setup a Kafka message listener
		container
				.setupMessageListener(new MessageListener<String, Email>() {
					@Override
					public void onMessage(
							ConsumerRecord<String, Email> record) {
						LOGGER.debug("test-listener received message='{}'",
								record.toString());
						records.add(record);
					}
				});

		// start the container and underlying message listener
		container.start();

		// wait until the container has the required number of assigned partitions
		ContainerTestUtils.waitForAssignment(container,
				embeddedKafka.getPartitionsPerTopic());
	}

	@After
	public void tearDown() {
		// stop the container
		container.stop();
	}

	@Test
	public void testSend() throws InterruptedException {
		// send the message
		Email email = Email.newBuilder()
				.setFrom("prathap.givantha@live.com")
				.setTo("prathap.givantha@live.co")
				.setSubject("Test")
				.setBody("Test")
				.build();
		publisher.sendMessage(email);

		// check that the message was received
		ConsumerRecord<String, Email> received =
				records.poll(10, TimeUnit.SECONDS);
		// Hamcrest Matchers to check the value
		assertThat(received, hasValue(email));
		// AssertJ Condition to check the key
		assertThat(received).has(key(null));
	}

}

