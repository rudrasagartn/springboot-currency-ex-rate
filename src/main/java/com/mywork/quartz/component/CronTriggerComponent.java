package com.mywork.quartz.component;

import java.util.Date;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mywork.quartz.job.TodaysExRateJob;

@Component
@PropertySource("classpath:cron-triggers.properties")
public class CronTriggerComponent {
	@Autowired
	private SchedulerFactoryBean schedulerFactory;

	@Bean
	public Date initJob(@Value("${TodaysExRateJob.cron.expression}") String cronExp) throws SchedulerException {
		Scheduler sched = schedulerFactory.getScheduler();
		JobDetail job = JobBuilder.newJob(TodaysExRateJob.class).withIdentity("TodaysExRateJob", "ExchangeRate").build();

		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("TodaysExRateTrigger", "ExchangeRate")
				.withSchedule(CronScheduleBuilder.cronSchedule(cronExp)).build();

		return sched.scheduleJob(job, trigger);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   return builder.build();
	}
	/*
	 * @Bean public Date initJob2(@Value("${job2.cron.expression}") String cronExp)
	 * throws SchedulerException { Scheduler sched =
	 * schedulerFactory.getScheduler(); JobDetail job =
	 * JobBuilder.newJob(SimpleJob2.class).withIdentity("job2", "group2").build();
	 * 
	 * CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger2",
	 * "group1") .withSchedule(CronScheduleBuilder.cronSchedule(cronExp)).build();
	 * 
	 * return sched.scheduleJob(job, trigger); }
	 */
}
