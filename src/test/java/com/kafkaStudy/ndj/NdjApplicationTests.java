package com.kafkaStudy.ndj;

import com.kafkaStudy.ndj.producer.KafkaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NdjApplicationTests {

	@Autowired
	private KafkaProducer kafkaProducer;
	@Test
	void contextLoads() {
		kafkaProducer.sendMessgae("카프카 테스트");
	}

}
