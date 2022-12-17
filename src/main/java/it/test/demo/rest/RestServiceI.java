package it.test.demo.rest;

import org.springframework.http.ResponseEntity;

import it.test.demo.rest.bean.RequestMoneyTransfer;

interface RestServiceI {
	String BASE_URL = "/accounts/{accountId}";

	public ResponseEntity<Object> account(String accountId);

	public ResponseEntity<Object> accountBalance(String accountId);

	public ResponseEntity<Object> accountTransactions(String accountId, String fromAccountingDate, String toAccountingDate);
	
	public ResponseEntity<Object> moneyTransfers(String accountId, RequestMoneyTransfer requestMoneyTransfer);
		
}