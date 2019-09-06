package com.ascend.streamkafka.config;

import com.ascend.streamkafka.stream.GreetingsStreams;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * Configure Spring Stream Cloud
 * Binding the streams is done using the @EnableBinding annotation where the GreetingsStreams interface is passed to.
 */
@EnableBinding(GreetingsStreams.class)
public class StreamConfig {

}
