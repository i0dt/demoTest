package it.test.demo.rest.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.test.demo.rest.bean.Account;
import it.test.demo.rest.bean.AccountBalance;
import it.test.demo.rest.bean.RequestMoneyTransfer;
import it.test.demo.rest.bean.ResponseMoneyTransfer;
import it.test.demo.rest.bean.Transaction;
import it.test.demo.rest.exception.CustomException;
import it.test.demo.rest.exception.ServerException;
import it.test.demo.rest.model.TransactionDb;
import it.test.demo.rest.repository.TransactionRepository;

@Service
public class AccountService extends AccountManagerA {
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);
	
	@Autowired
	private ExternalServiceI externalService;
	
	@Autowired
	private TransactionRepository transactionRepository;


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
		List<Transaction> lists = externalService.listTransactions(accountId, fromDate, toDate);
		if (lists.size() > 0) {
			for (Transaction tran : lists) {
				TransactionDb transactionDb = new TransactionDb();
				transactionDb.setTransactionId(tran.getTransactionId());
				transactionDb.setOperationId(tran.getOperationId());
				transactionDb.setAmount(tran.getAmount());
				if(!transactionRepository.existsById(accountId)) {
					transactionRepository.save(mapTransactionDb(tran));
				}

			}
			
			transactionRepository.findAll().forEach((transactionDb) -> {
				LOGGER.debug("TransactionDb->{}", transactionRepository.findById(transactionDb.getTransactionId()).toString());
			});
		}
		
		return lists;
	}

	/**
	 * Account service make money transfers of payments
	 */
	@Override
	public ResponseMoneyTransfer moneyTransfers(String accountId, RequestMoneyTransfer requestMoneyTransfer) throws CustomException, ServerException {
		return externalService.moneyTransfers(accountId, requestMoneyTransfer);
	}

}
