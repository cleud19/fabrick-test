package it.client.rest.fabricktest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import it.client.rest.fabricktest.service.AccountServiceImpl;

/**
 * 
 * @author Claudiu Iancu
 *  
 */
@SpringBootApplication
public class FabrickTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FabrickTestApplication.class, args);

	}

}
 