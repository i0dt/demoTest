package it.test.demo.rest.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.test.demo.rest.bean.Account;
import it.test.demo.rest.bean.AccountBalance;
import it.test.demo.rest.bean.RequestMoneyTransfer;
import it.test.demo.rest.bean.ResponseMoneyTransfer;
import it.test.demo.rest.bean.Transaction;
import it.test.demo.rest.exception.CustomException;
import it.test.demo.rest.exception.ServerException;

@Service
public class AccountService extends AccountManagerA {
	@Autowired
	private ExternalServiceI externalService;

	/**
	 * Account service to get info of account
	 */
	@Override
	public Account getAccount(String accountId) throws CustomException, ServerException {
		return externalService.getAccount(accountId);
	}

	/**
	 * Account service to get balance of account
	 */
	@Override
	public AccountBalance getBalance(String accountId) throws CustomException, ServerException {
		return externalService.getBalance(accountId);
	}

	
	/**
	 * Account service to list transactions of account
	 */
	@Override
	public List<Transaction> listTransactions(String accountId, String fromAccountingDate, String toAccountingDate) throws CustomException, ServerException {
		Date fromDate = getDate(fromAccountingDate);
		Date toDate = getDate(toAccountingDate);
		return externalService.listTransactions(accountId, fromDate, toDate);
	}

	/**
	 * Account service make money transfers of payments
	 */
	@Override
	public ResponseMoneyTransfer moneyTransfers(String accountId, RequestMoneyTransfer requestMoneyTransfer) throws CustomException, ServerException {
		return externalService.moneyTransfers(accountId, requestMoneyTransfer);
	}

}
