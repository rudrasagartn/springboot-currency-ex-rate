package com.mywork.quartz.job;
import java.text.SimpleDateFormat;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.mywork.exchangerate.service.ExchangeRateService;

public class TodaysExRateJob implements Job {

	@Autowired
	ExchangeRateService exRateService;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		SimpleDateFormat df = new SimpleDateFormat("dd-mm-yyyy hh:mm:ss");
		System.out.println("Simple Job : "+ df.format(context.getFireTime()));
		exRateService.getTodaysExRate();
	}

}
