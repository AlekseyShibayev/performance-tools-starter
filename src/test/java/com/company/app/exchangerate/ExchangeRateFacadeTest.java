package com.company.app.exchangerate;

import com.company.app.ApplicationTest;
import com.company.app.exchangerate.entity.ExchangeRate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class ExchangeRateFacadeTest extends ApplicationTest {

	@Autowired
	private ExchangeRateFacade exchangeRateFacade;

	@Test
	void extractCurse() {
		ExchangeRate exchangeRate = exchangeRateFacade.extract();
		Assertions.assertNotNull(exchangeRate.getAliexpressExchangeRate());
	}
}