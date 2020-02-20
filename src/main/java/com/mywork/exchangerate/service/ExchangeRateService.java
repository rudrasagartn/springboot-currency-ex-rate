package com.mywork.exchangerate.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.mywork.exchangerate.bean.ExchangeRate;
import com.mywork.exchangerate.dto.ExchangeRateDto;

public interface ExchangeRateService {
	
	public List<ExchangeRate> getTodaysExRate();
	public ResponseEntity<ExchangeRateDto> getExRateForDate(String date);
	public Iterable<ExchangeRate> saveExchangeRate(List<ExchangeRate> exchangeRates);

}
