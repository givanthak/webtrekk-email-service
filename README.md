
# Webtrekk Email Service #

**A simple microservice responsible of asynchronous sending of emails**

This is a simple microservice responsible of sending emails asynchronous, using Spring Boot, Spring Mail , Apache Kafka, Apache Avro, confluent schema registry.


#### Email Service ###


#### Technologies Stack and dependency ###

Java 8
Spring Boot 2.0.5
Apache Avro 1.8.2
Spring-Kafka 2.1.10   
Swagger2
Confluent
Lombok

### How to run all the things? ##

##### Spring Kafka Properties 

```yml
spring.kafka.bootstrapAddress=localhost:9092
spring.kafka.schemaRegistryAddress=http://localhost:8081
spring.kafka.auto-offset-reset=earliest
spring.kafka.max.redelivery.attempts=3
spring.kafka.max.redelivery.interval=5000
```

##### Kafka Topic Properties
app.email.topic-name=email.service.topic
app.email.topic-group=email


##### Email Properties
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


#### Before you start #

#### Important endpoints
- http://localhost:9000/swagger-ui.html - Swagger Api Defenition
