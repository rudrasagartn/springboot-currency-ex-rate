package com.mywork.exchangerate.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mywork.exchangerate.bean.ExchangeRate;
import com.mywork.exchangerate.dto.ExchangeRateDto;
import com.mywork.exchangerate.service.ExchangeRateService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ExchangeRateController {

	@Autowired
	ExchangeRateService exRService;

	@ApiOperation(value = "Get request call to retrive exchange rate for patricular date", response = ExchangeRateDto.class, responseContainer = "Object")
	@RequestMapping(value = "/exrate-api/get/exchangerate/{date}", method = RequestMethod.GET)
	public List<ExchangeRate> getExRateForDate(@PathVariable("date") String date) {
		ResponseEntity<ExchangeRateDto> response = exRService.getExRateForDate(date);
		List<ExchangeRate> exRates = processResponse(response);
		exRService.saveExchangeRate(exRates);
		return exRates;
	}

	@ApiOperation(value = "Demonstrate query/request param")
	@RequestMapping(value = "/exrate-api/get/exrate", method = RequestMethod.GET)
	public void getExRateForDate2(@RequestParam(value = "date") String date) {
		System.out.println(date);
	}
	
	
	private List<ExchangeRate> processResponse(ResponseEntity<ExchangeRateDto> response) {
		List<ExchangeRate> exRates = new ArrayList<>();
		Map<String, Double> rates = response.getBody().getRates();
		for (Map.Entry<String, Double> mapObject : rates.entrySet()) {
			ExchangeRate ex = new ExchangeRate(mapObject.getKey(), mapObject.getValue(), response.getBody().getDate(),
					response.getBody().getBase());
			exRates.add(ex);
		}
		return exRates;
	}

}
