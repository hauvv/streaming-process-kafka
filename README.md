# streaming-process-kafka
This sample project demonstrates how to build real-time streaming applications using event-driven architecture, Spring Boot, Spring Cloud Stream, Apache Kafka

Install Kafka on Mac:
$ brew install kafka
$ brew services start zookeeper
$ brew services start kafka
Check message in Kafka topic
#input
$ kafka-console-producer --broker-list localhost:9092 --topic greetings
#output
$ kafka-console-consumer --bootstrap-server localhost:9092 --from-beginning --topic greetings

Run app:
$ mvn spring-boot:run
Call api:
http://localhost:8081/greetings?message=abc-123
Output:
2019-09-06 14:40:44.739  INFO 21998 --- [nio-8081-exec-1] c.a.s.services.GreetingsService          : Sending greetings: Greetings(timestamp=1567755644735, message=abc-123)
2019-09-06 14:40:44.817  INFO 21998 --- [nio-8081-exec-1] c.a.s.services.GreetingsListener         : Received message: Greetings(timestamp=1567755644735, message=abc-123)
