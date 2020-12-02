package it.client.rest.fabricktest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import it.client.rest.fabricktest.configuration.ConfigurationTestClass;

/**
 * 
 * @author Claudiu Iancu
 *  
 */
@SpringBootTest
@ContextConfiguration(classes=ConfigurationTestClass.class)
class FabrickTestApplicationTests {

	@Test
	void contextLoads() {
	}

}
