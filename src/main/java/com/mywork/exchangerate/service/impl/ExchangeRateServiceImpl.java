package com.mywork.exchangerate.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mywork.exchangerate.bean.ExchangeRate;
import com.mywork.exchangerate.dao.IExchangeRateDao;
import com.mywork.exchangerate.dto.ExchangeRateDto;
import com.mywork.exchangerate.service.ExchangeRateService;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	IExchangeRateDao exchangeRateDao;

	public ExchangeRate getTodaysExRate() {
		List<ExchangeRate> exRates = new ArrayList<>();
		ResponseEntity<ExchangeRateDto> res = restTemplate.getForEntity("https://api.exchangeratesapi.io/2010-01-12",
				ExchangeRateDto.class);
		Map<String, Double> rates = res.getBody().getRates();
		for (Map.Entry<String, Double> mapObject : rates.entrySet()) {
			ExchangeRate ex = new ExchangeRate(mapObject.getKey(), mapObject.getValue(), res.getBody().getDate(),
					res.getBody().getBase());
			exRates.add(ex);
		}
		exchangeRateDao.saveAll(exRates);

		return null;

	}

}
