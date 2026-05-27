package com.example.backend;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Disabled("Disabled because CI/CD environment does not run PostgreSQL, MongoDB, Redis, and Kafka infrastructure.")
@SpringBootTest
class BackendApplicationTests {

	@Test
	void contextLoads() {
	}

}
