package com.ascend.streamkafka.services;

import com.ascend.streamkafka.model.Greetings;
import com.ascend.streamkafka.stream.GreetingsStreams;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

/**
 * Write the Greetings Object to Kafka topic (greetings)
 */
@Service
@Log4j2
public class GreetingsService {

  private final GreetingsStreams greetingsStreams;

  public GreetingsService(GreetingsStreams greetingsStreams) {
    this.greetingsStreams = greetingsStreams;
  }

  public void sendGreeting(final Greetings greetings) {
    log.info("Sending greetings: " + greetings);
    MessageChannel messageChannel = greetingsStreams.outboundGreetings();
    messageChannel.send(MessageBuilder
        .withPayload(greetings)
        .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
        .build());
  }
}
