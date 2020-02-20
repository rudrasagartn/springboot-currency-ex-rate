package com.mywork;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import com.mywork.exchangerate.bean.ExchangeRate;
import com.mywork.exchangerate.service.ExchangeRateService;

@SpringBootTest
class SpringbootCurrencyExRateApplicationTests {

	@Autowired
	private ExchangeRateService exchangeRateService;

	@Test
	void testGetExRateForDate() {
		assertEquals(HttpStatus.OK, exchangeRateService.getExRateForDate("2020-02-19").getStatusCode());
	}

	@Test
	void testSaveExchangeRate() {
		assertEquals(new ArrayList<ExchangeRate>(),
				exchangeRateService.saveExchangeRate(new ArrayList<ExchangeRate>()));
	}

}
