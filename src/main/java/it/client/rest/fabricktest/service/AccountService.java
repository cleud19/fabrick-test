package it.client.rest.fabricktest.service;

import it.client.rest.fabricktest.model.Balance;
import it.client.rest.fabricktest.model.MoneyTransferRequest;
import it.client.rest.fabricktest.model.MoneyTransferResponse;
import it.client.rest.fabricktest.model.ResponseObject;

public interface AccountService {
	
	ResponseObject<Balance> getBalanceById(String id);
	ResponseObject<MoneyTransferResponse> createMoneyTransfer(MoneyTransferRequest moneyTransferRequest, String accountId);
}
