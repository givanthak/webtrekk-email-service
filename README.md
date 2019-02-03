
# Webtrekk Email Service #

**A simple microservice responsible of asynchronous sending of emails**

This is a simple microservice responsible of sending emails asynchronous, using Spring Boot, Spring Mail , Apache Kafka, Apache Avro, confluent schema registry.

<img width="880" src="https://github.com/givanthak/webtrekk-email-service/blob/master/howitswork.jpg">

#### Email Service ###

#### Technologies Stack and dependency ###

- Java 8
- Spring Boot 2.0.5
- Apache Avro 1.8.2
- Spring-Kafka 2.1.10   
- Swagger2
- Lombok

- Apache Kafka 2.11.2
- Confluent 5.1.0

### How to run all the things? ##

Fist configur the email service properties for thatgo to project `src/main/resources/application.properties` step by step we need to configure the below 

##### Spring Kafka Properties 

```yml
spring.kafka.bootstrapAddress=localhost:9092
spring.kafka.schemaRegistryAddress=http://localhost:8081
spring.kafka.auto-offset-reset=earliest
spring.kafka.max.redelivery.attempts=3
spring.kafka.max.redelivery.interval=5000
```

##### Kafka Topic Properties

```yml
app.email.topic-name=email.service.topic
app.email.topic-group=email
```

##### Email Properties

smtp email configuration details

```yml
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=pratha.givantha@gmail.com
spring.mail.password=rwdsdwerwerwerder
spring.mail.properties.mail.smtp.transport.protocol=smtp
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.connectiontimeout=6000
spring.mail.properties.mail.smtp.timeout=6000
spring.mail.properties.mail.smtp.writetimeout=6000
spring.mail.properties.mail.debug=true
```

#### Before you start #

##### preconfigurations 

Befor start the mail service you need Apache Kafka and Confluent install in your machine.


after that follow below steps to run the email service 

##### Start the servers

##### Start Apache Kafka Server 

Go to 
`cd kafka_2.11-2.1.0`

1. Kafka uses ZooKeeper so you need to first start a ZooKeeper server 

`bin/zookeeper-server-start.sh config/zookeeper.properties`

2. Now start the Kafka server

`bin/kafka-server-start.sh config/server.properties`

3. Create a topic

`bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic email.service.topic`

4. We can now see that topic if we run the list topic command

`bin/kafka-topics.sh --list --zookeeper localhost:2181`

##### Start Confluent for schema registry 

Go to 
`cd kafka_2.11-2.1.0`

 Now start the confluent schema registry

`bin/schema-registry-start ./etc/schema-registry/schema-registry.properties`

##### Start Webtrekk Email Service

Go to 
`cd webtrekk-email-service`

execute the 
` mvn exec:java or mvn spring-boot:run`

#### Important endpoints

- http://localhost:9000/swagger-ui.html - Swagger Api Defenition



