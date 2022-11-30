package com.company.app.config;

import com.company.app.services.api.ExchangeExtractorService;
import com.company.app.services.api.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)
public class SchedulerConfig {

	@Autowired
	private NotificationService notificationService;
	@Autowired
	private ExchangeExtractorService exchangeExtractorService;

	@Scheduled(fixedDelayString = "${writeExchange.timeout}")
	public void writeExchange() {
		notificationService.eventNotification(exchangeExtractorService.extractCurse());
	}
}