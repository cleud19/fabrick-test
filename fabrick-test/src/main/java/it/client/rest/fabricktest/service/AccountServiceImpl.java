package it.client.rest.fabricktest.service;

import static java.lang.String.format;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import it.client.rest.fabricktest.loginterceptor.RequestResponseLoggingInterceptor;
import it.client.rest.fabricktest.model.Balance;
import it.client.rest.fabricktest.model.MoneyTransferRequest;
import it.client.rest.fabricktest.model.MoneyTransferResponse;
import it.client.rest.fabricktest.model.ResponseObject;
import it.client.rest.fabricktest.model.Transaction;
import it.client.rest.fabricktest.model.TransactionList;

@Service
public class AccountServiceImpl implements AccountService{
	
	static final String BASE_URL="https://sandbox.platfr.io/";
	
	@Autowired
	private RestTemplate restTemplate;
	 
	public ResponseObject<Balance> getBalanceById(String accountId) {
		
		String serviceUrl =BASE_URL + format("/api/gbs/banking/v4.0/accounts/%s/balance", accountId);
		
		HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        requestHeaders.set("Auth-Schema","S2S");
        requestHeaders.set("apikey","FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
        
        ParameterizedTypeReference<ResponseObject<Balance>> responseType = new ParameterizedTypeReference<ResponseObject<Balance>>() {};
        	     
        HttpEntity<ResponseObject<Balance>> entity = new HttpEntity<>(requestHeaders);
        ResponseEntity<ResponseObject<Balance>>  response = restTemplate.exchange(serviceUrl,HttpMethod.GET, entity,responseType);
        
        HttpStatus status = response.getStatusCode();
        if (status != HttpStatus.OK) {
        	System.out.println(format("There was an error calling: %s", serviceUrl));
        	System.out.println(response);	
        }
        return response.getBody();
	}
	
	public ResponseObject<MoneyTransferResponse> createMoneyTransfer(MoneyTransferRequest moneyTransferRequest, String accountId){
		
		String serviceUrl = BASE_URL + format("/api/gbs/banking/v4.0/accounts/%s/payments/money-transfers", accountId);
		
		HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        requestHeaders.set("Auth-Schema","S2S");
        requestHeaders.set("apikey","FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
        
        ParameterizedTypeReference<ResponseObject<MoneyTransferResponse>> responseType = new ParameterizedTypeReference<ResponseObject<MoneyTransferResponse>>() {};
        HttpEntity<MoneyTransferRequest> entity = new HttpEntity<>(moneyTransferRequest, requestHeaders);
        
        
        ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
        
        RestTemplate restTemplate = new RestTemplate(factory);
         
        restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
        
        ResponseEntity<ResponseObject<MoneyTransferResponse>> response = restTemplate.exchange(serviceUrl,HttpMethod.POST, entity,responseType);
        
        HttpStatus status = response.getStatusCode();
        if (status != HttpStatus.OK) {
        	System.out.println(format("There was an error calling: %s", serviceUrl));
        	System.out.println(response);	
        }
        return response.getBody();
	}
	
	public ResponseObject<TransactionList> getTransactionByIdAndDate(String accountId,LocalDate fromAccountingDate,LocalDate toAccountingDate) {
		
		String serviceUrl = BASE_URL + format("/api/gbs/banking/v4.0/accounts/%s/transactions", accountId);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(serviceUrl)
                .queryParam("fromAccountingDate", fromAccountingDate.toString())
                .queryParam("toAccountingDate", toAccountingDate.toString());
        
		
		HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        requestHeaders.set("Auth-Schema","S2S");
        requestHeaders.set("apikey","FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
        
        ParameterizedTypeReference< ResponseObject<TransactionList>> responseType = new ParameterizedTypeReference<ResponseObject<TransactionList>>() {};
        	     
        HttpEntity<ResponseObject<TransactionList>> entity = new HttpEntity<>(requestHeaders);
        
        ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());
        
        RestTemplate restTemplate = new RestTemplate(factory);
         
        restTemplate.setInterceptors(Collections.singletonList(new RequestResponseLoggingInterceptor()));
        
        ResponseEntity<ResponseObject<TransactionList>>  response = restTemplate.exchange(builder.toUriString(),HttpMethod.GET, entity,responseType);
         
        HttpStatus status = response.getStatusCode();
        if (status != HttpStatus.OK) {
        	System.out.println(format("There was an error calling: %s", serviceUrl));
        	System.out.println(response);	
        }
        return response.getBody();
	}
	
}
