package org.vin;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;

public class KafkaTest1 {
	public static void main(String[] args) {

		Properties props = new Properties();
		props.put("bootstrap.servers", "hadoop103:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		// 16m
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.common.serialization.StringSerializer");

		KafkaProducer<Object, Object> producer = new KafkaProducer<>(props);

		ProducerRecord producerRecord = new ProducerRecord("topic", "test");

		producer.send(new ProducerRecord("topic", "test"), new Callback() {
			@Override
			public void onCompletion(RecordMetadata metadata, Exception exception) {
				long offset = metadata.offset();
				int partition = metadata.partition();
				String topic = metadata.topic();
			}
		});



	}
}
