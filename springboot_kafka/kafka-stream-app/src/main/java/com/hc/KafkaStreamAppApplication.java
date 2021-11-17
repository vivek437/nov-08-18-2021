package com.hc;

import java.util.HashMap;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Printed;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;

@SpringBootApplication
@Configuration
@EnableKafkaStreams
public class KafkaStreamAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaStreamAppApplication.class, args);
	}
	
	@Bean
	public KStream<String, String> kstreamSquaredNumber(StreamsBuilder builder) {
		KStream<String, String> source = builder.stream("t_forstreams_source", Consumed.with(Serdes.String(), Serdes.String()));
		KStream<String, String> squaredStream = source.mapValues(it -> Integer.parseInt(it)).mapValues(it -> (it * it) + "");
		squaredStream.to("t_forstreams_sink");
		
		source.print(Printed.<String, String>toSysOut().withLabel("====From source"));
		squaredStream.print(Printed.<String, String>toSysOut().withLabel("****After squaring"));
		return source;
	}
	
	@Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
	public KafkaStreamsConfiguration kafkaStreamsConfig() {
		var props = new HashMap<String, Object>();
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "kafka-stream");
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
		props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
		return new KafkaStreamsConfiguration(props);
	}
	

}
