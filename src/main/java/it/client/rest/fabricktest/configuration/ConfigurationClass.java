package it.client.rest.fabricktest.configuration;

import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import it.client.rest.fabricktest.loginterceptor.RequestResponseLoggingInterceptor;
import it.client.rest.fabricktest.service.AccountServiceImpl;


/**
 * 
 * @author Claudiu Iancu
 *  
 */
@Configuration
public class ConfigurationClass {

	@Bean
	RestTemplate getRestTemplate() {
		 final Logger log = LoggerFactory.getLogger(RequestResponseLoggingInterceptor.class);
		 if (log.isDebugEnabled()) {
			 ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
			 RestTemplate restTemplate = new RestTemplate(factory);
			 restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
			 return restTemplate;
	    }
		
		return new RestTemplate();
	}
	
	@Bean
	public AccountServiceImpl accountService() {
		return new AccountServiceImpl();
	}
	
}
