package it.client.rest.fabricktest.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.client.HttpClientErrorException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.client.rest.fabricktest.configuration.ConfigurationTestClass;
import it.client.rest.fabricktest.model.Account;
import it.client.rest.fabricktest.model.Balance;
import it.client.rest.fabricktest.model.Creditor;
import it.client.rest.fabricktest.model.MoneyTransferRequest;
import it.client.rest.fabricktest.model.MoneyTransferResponse;
import it.client.rest.fabricktest.model.ResponseObject;
import it.client.rest.fabricktest.model.TransactionList;


/**
 * 
 * @author Claudiu Iancu
 *  
 */
@SpringBootTest
@TestPropertySource("classpath:application.properties")
@ContextConfiguration(classes=ConfigurationTestClass.class, loader=AnnotationConfigContextLoader.class)
public class AccountServiceTest {

	@Autowired
	AccountServiceImpl accountService;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	 
	/**
     * Retrieves the balance of an account.
     * Should Return Invalid Account Identifier because the AccountId 123456 doesn't exist
     */
	@Test()
	public void shouldReturnInvalidAccountIdentifier() throws JsonMappingException, JsonProcessingException {
		log.info("");
		log.info("AccountServiceTest - ShouldReturnInvalidAccountIdentifier START");
		ResponseObject<Balance> errorResponseObject = null;
		
		try{
			ResponseObject<Balance>  response =accountService.getBalanceById("123456");			
		}catch (HttpClientErrorException e) {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			TypeReference<ResponseObject<Balance>> typeRef  = new TypeReference<ResponseObject<Balance>>() {};
			errorResponseObject = objectMapper.readValue(e.getResponseBodyAsString(), typeRef);
			log.debug(errorResponseObject.toString());
			
			assert errorResponseObject.getErrors().stream().anyMatch(s -> s.getCode().equals("REQ004"));
			log.debug("TEST OK!");
			log.info("");
		}
		
	}
	
	/**
     * Retrieves the balance of an account.
     * Should Return the Balance of the Account 14537780
     */
	@Test()
	public void shouldReturnBalance() {
		log.info("");
		log.info("AccountServiceTest - shouldReturnBalance START");

		ResponseObject<Balance> response = accountService.getBalanceById("14537780");
		log.debug(response.toString());
		assert !response.getPayload().getBalance().isEmpty();
		log.debug("TEST OK!");
		log.info("");
	}
	
	/**
     * Send a money Transfer Request
     * Should Return API000 Error
     */
	@Test()
	public void shouldGetAPI000Error() throws JsonMappingException, JsonProcessingException {
		log.info("");
		log.info("AccountServiceTest - shouldGetAPI000Error START");
		ResponseObject<Balance> errorResponseObject = null;
		Account account = new Account("IT23A0336844430152923804660","SELBIT2BXXX");
		Creditor creditor = new Creditor("John Doe",account);
		MoneyTransferRequest moneyTransfReq = new MoneyTransferRequest(creditor,"Payment invoice 75/2017","800",LocalDate.now(),"EUR");
		try {
			ResponseObject<MoneyTransferResponse> response = accountService.createMoneyTransfer(moneyTransfReq, "14537780");
		}catch (HttpClientErrorException e) {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			TypeReference<ResponseObject<Balance>> typeRef  = new TypeReference<ResponseObject<Balance>>() {};
			errorResponseObject = objectMapper.readValue(e.getResponseBodyAsString(), typeRef);
			log.debug(errorResponseObject.toString());
			
			assert errorResponseObject.getErrors().stream().anyMatch(s -> s.getCode().equals("API000"));
			log.debug("TEST OK!");
			log.info("");
		}
	
	}
	
	/**
     * Retrieves the transactions of an Account
     * Should Return the transactions of the Account 14537780 from 2019-01-01 to 2019-12-01
     */
	@Test()
	public void shouldReturnTransactions() {
		log.info("");
		log.info("AccountServiceTest - shouldReturnTransactions START");
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
        String fromAccountingStringDate = "2019-01-01";       
        String toAccountingStringDate="2019-12-01";
        
        LocalDate fromAccountingDate = LocalDate.parse(fromAccountingStringDate, formatter);
        LocalDate toAccountingDate = LocalDate.parse(toAccountingStringDate, formatter);
        
		ResponseObject<TransactionList> response = accountService.getTransactionByIdAndDate("14537780",fromAccountingDate,toAccountingDate);
		log.debug(response.toString());
		assert response.getPayload().getList().stream().anyMatch(s -> s.getOperationId().equals("00000000282831"));
		log.debug("TEST OK!");
		log.info("");
	}
	
}
