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
 - Settare il livello di log a DEBUG di it.client.rest.fabricktest.loginterceptor in application.properties per abilitare 
   il log dei  Body e Headers delle Request e Response. 
 
