package com.mywork.exchangerate.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mywork.exchangerate.bean.ExchangeRate;

@Repository
public interface IExchangeRateDao extends CrudRepository<ExchangeRate, Integer> {

}
