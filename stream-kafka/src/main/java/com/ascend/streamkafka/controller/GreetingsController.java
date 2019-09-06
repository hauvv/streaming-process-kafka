package com.ascend.streamkafka.controller;

import com.ascend.streamkafka.model.Greetings;
import com.ascend.streamkafka.services.GreetingsListener;
import com.ascend.streamkafka.services.GreetingsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {

  final private GreetingsService greetingsService;
  final private GreetingsListener greetingsListener;

  public GreetingsController(GreetingsService greetingsService,
      GreetingsListener greetingsListener) {
    this.greetingsService = greetingsService;
    this.greetingsListener = greetingsListener;
  }

  @GetMapping("greetings")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void greetings(@RequestParam("message") String message) {
    Greetings greetings = Greetings.builder().message(message).timestamp(System.currentTimeMillis())
        .build();
    // send message to Kafka topic
    greetingsService.sendGreeting(greetings);
    // read message from Kafka topic
    greetingsListener.handleGreetings(greetings);
  }
}
