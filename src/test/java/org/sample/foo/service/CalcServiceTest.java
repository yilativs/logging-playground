package org.sample.foo.service;

import org.junit.jupiter.api.Test;
import org.sample.foo.conf.AopConfiguration;
import org.sample.foo.conf.BaseConfiguration;
import org.sample.foo.conf.LogConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.NONE, classes = { BaseConfiguration.class, AopConfiguration.class,
		LogConfiguration.class })
public class CalcServiceTest {

	@Autowired
	CalcService service;

	@Test
	void logsTruncated() {
		service.calc(12345678);
	}

}
