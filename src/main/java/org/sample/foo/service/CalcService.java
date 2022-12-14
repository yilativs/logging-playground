package org.sample.foo.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CalcService {

	Logger logger;

	public CalcService(Logger logger) {
		this.logger = logger;
	}

	public void calc(Integer i) {
		logger.info(i.toString());
	}

}
