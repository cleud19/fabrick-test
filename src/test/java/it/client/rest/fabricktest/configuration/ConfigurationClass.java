package it.client.rest.fabricktest.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import it.client.rest.fabricktest.service.AccountServiceImpl;

@TestConfiguration
public class ConfigurationClass {

	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public AccountServiceImpl accountService() {
		return new AccountServiceImpl();
	}
	
}
