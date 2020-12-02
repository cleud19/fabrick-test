package it.client.rest.fabricktest.error;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;

@Component
public class RestTemplateResponseErrorHandler extends DefaultResponseErrorHandler {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
    @Override
    public void handleError(ClientHttpResponse httpResponse) 
      throws IOException {

        if (httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR) {
            
            if (httpResponse.getStatusCode() == HttpStatus.FORBIDDEN) {
            	log.error("Forbidden Error");
            }
        }
    }

	
}