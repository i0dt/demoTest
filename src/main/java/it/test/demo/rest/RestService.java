package it.test.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.test.demo.rest.bean.RequestMoneyTransfer;
import it.test.demo.rest.bean.ResponseMoneyTransfer;
import it.test.demo.rest.exception.CustomException;
import it.test.demo.rest.exception.ServerException;
import it.test.demo.rest.service.AccountManagerI;

/**
 * Rest controllo for handle account, account balance, list transactions and money transfers for payment
 * @author 
 *
 */
@RestController
public class RestService extends RestServiceA {
	private int CUSTOM_HTTP_STATUS_ERROR = 444;
	private int CUSTOM_SERVER_STATUS_ERROR = 555;

	@Autowired
	private AccountManagerI accountManager;
	
	
	/**
	 * Http request to get generic account info
	 */
	@GetMapping(BASE_URL)
	public ResponseEntity<Object> account(@PathVariable String accountId) {
		try {
			validateAccountInput(accountId);
			return ResponseEntity.ok().headers(httpHeaders()).body(accountManager.getAccount(accountId));
		} catch (CustomException e) {
			return ResponseEntity.status(CUSTOM_HTTP_STATUS_ERROR).headers(httpHeaders()).body(e.getErrors());
		} catch (ServerException e) {
			return ResponseEntity.status(CUSTOM_SERVER_STATUS_ERROR).headers(httpHeaders()).body(e.getErrors());
		}
	}

	/**
	 *  Http request to get balance of account
	 */
	@GetMapping(BASE_URL + "/balance")
	public ResponseEntity<Object> accountBalance(@PathVariable String accountId) {
		try {
			validateBalanceInput(accountId);
			return ResponseEntity.ok().headers(httpHeaders()).body(accountManager.getBalance(accountId));
		} catch (CustomException e) {
			return ResponseEntity.status(CUSTOM_HTTP_STATUS_ERROR).headers(httpHeaders()).body(e.getErrors());
		} catch (ServerException e) {
			return ResponseEntity.status(CUSTOM_SERVER_STATUS_ERROR).headers(httpHeaders()).body(e.getErrors());
		}
	}

	/**
	 * Http request to list the transactions
	 */
	@GetMapping(BASE_URL + "/transactions")
	public ResponseEntity<Object> accountTransactions(@PathVariable String accountId, @RequestParam(name = "fromAccountingDate") String fromAccountingDate, @RequestParam(name = "toAccountingDate") String toAccountingDate) {
		try {
			validateTransactionsInput(accountId, fromAccountingDate, toAccountingDate);
			return ResponseEntity.ok().headers(httpHeaders()).body(accountManager.listTransactions(accountId, fromAccountingDate, toAccountingDate));
		} catch (CustomException e) {
			return ResponseEntity.status(CUSTOM_HTTP_STATUS_ERROR).headers(httpHeaders()).body(e.getErrors());
		} catch (ServerException e) {
			return ResponseEntity.status(CUSTOM_SERVER_STATUS_ERROR).headers(httpHeaders()).body(e.getErrors());
		}
	}

	/**
	 * Http request post for money transfers of payments
	 */
	@PostMapping(BASE_URL + "/payments/money-transfers")
	public ResponseEntity<Object> moneyTransfers(@PathVariable String accountId, @RequestBody RequestMoneyTransfer requestMoneyTransfer) {
		try {
			validateMoneyTransferInput(accountId, requestMoneyTransfer);
			ResponseMoneyTransfer response = accountManager.moneyTransfers(accountId, requestMoneyTransfer);
			return ResponseEntity.ok().headers(httpHeaders()).body(response);
		} catch (CustomException e) {
			return ResponseEntity.status(CUSTOM_HTTP_STATUS_ERROR).headers(httpHeaders()).body(e.getErrors());
		} catch (ServerException e) {
			return ResponseEntity.status(CUSTOM_SERVER_STATUS_ERROR).headers(httpHeaders()).body(e.getErrors());
		}
	}
}