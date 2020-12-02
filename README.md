# fabrick-test
Applicazione di test che consente di eseguire tre operazioni: 

 Lettura saldo 
 	API: https://docs.fabrick.com/platform/apis/gbs-banking-account-cash-v4.0
  
 Bonifico
  API: https://docs.fabrick.com/platform/apis/gbs-banking-payments-moneyTransfers-v4.0
  
 Lettura Transazioni
	API: https://docs.fabrick.com/platform/apis/gbs-banking-account-cash-v4.0

Per testare il funzionamento del applicativo:
 - Importare il progetto in qualsiasi IDE e eseguire i test. 
 - Eseguire comando Run Spring Boot App e testare in locale le chiamate: 
 
 	- GET: http://localhost:8080/accounts/14537780/transactions?fromAccountingDate=2019-01-01&toAccountingDate=2019-12-01
	- GET: http://localhost:8080/accounts/14537780/payments/money-transfers
	- GET: http://localhost:8080/accounts/14537780/balance
 
 	- POST: http://localhost:8080/accounts/14537780/payments/money-transfers
 	  Passare come body l'oggetto d'esempio da documentazione API: https://docs.fabrick.com/platform/apis/gbs-banking-payments-moneyTransfers-v4.0
 
NB Settare il livello di log a DEBUG di it.client.rest.fabricktest.loginterceptor in application.properties per abilitare 
   il log dei  Body e Headers delle Request e Response. 
 
