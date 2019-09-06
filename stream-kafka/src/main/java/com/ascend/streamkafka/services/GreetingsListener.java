package com.ascend.streamkafka.services;

import com.ascend.streamkafka.model.Greetings;
import com.ascend.streamkafka.stream.GreetingsStreams;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Listener message from Kafka topic
 */
@Component
@Log4j2
public class GreetingsListener {

  @StreamListener(GreetingsStreams.INPUT)
  public void handleGreetings(@Payload Greetings greetings) {
    log.info("Received message: " + greetings);
  }
}
