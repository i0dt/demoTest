package it.test.demo.rest.service;

import java.util.Date;
import java.util.List;

import it.test.demo.rest.bean.Account;
import it.test.demo.rest.bean.AccountBalance;
import it.test.demo.rest.bean.RequestMoneyTransfer;
import it.test.demo.rest.bean.ResponseMoneyTransfer;
import it.test.demo.rest.bean.Transaction;
import it.test.demo.rest.exception.CustomException;
import it.test.demo.rest.exception.ServerException;

interface ExternalServiceI {
	public Account getAccount(String accountId) throws CustomException, ServerException;

	public AccountBalance getBalance(String accountId) throws CustomException, ServerException;

	public List<Transaction> listTransactions(String accountId, Date fromAccountingDate, Date toAccountingDate) throws CustomException, ServerException;

	public ResponseMoneyTransfer moneyTransfers(String accountId, RequestMoneyTransfer requestMoneyTransfer) throws CustomException, ServerException;
}
