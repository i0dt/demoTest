package it.test.demo.rest.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import it.test.demo.rest.bean.Account;
import it.test.demo.rest.bean.AccountBalance;
import it.test.demo.rest.bean.RequestMoneyTransfer;
import it.test.demo.rest.bean.Response;
import it.test.demo.rest.bean.ResponseMoneyTransfer;
import it.test.demo.rest.bean.Transaction;
import it.test.demo.rest.bean.TransactionLists;
import it.test.demo.rest.exception.CustomException;
import it.test.demo.rest.exception.ServerException;

@Service
public class ExternalService extends ExternalServiceA {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExternalService.class);
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Account getAccount(String accountId) throws CustomException, ServerException {
		LOGGER.info(getUrlAccount(accountId));
		ResponseEntity<Response<Account>> response = restTemplate.exchange(getUrlAccount(accountId), HttpMethod.GET, new HttpEntity<>(getHttpHeaders()), new ParameterizedTypeReference<Response<Account>>() {
		});
		if (response.getStatusCode().is2xxSuccessful()) {
			return response.getBody().getPayload();
		} else if (response.getStatusCode().is4xxClientError()) {
			throw new CustomException(response.getBody().getErrors());
		} else {
			throw new ServerException();
		}
	}

	@Override
	public AccountBalance getBalance(String accountId) throws CustomException, ServerException {
		LOGGER.info(getUrlBalance(accountId));
		ResponseEntity<Response<AccountBalance>> response = restTemplate.exchange(getUrlBalance(accountId), HttpMethod.GET, new HttpEntity<>(getHttpHeaders()), new ParameterizedTypeReference<Response<AccountBalance>>() {
		});
		if (response.getStatusCode().is2xxSuccessful()) {
			return response.getBody().getPayload();
		} else if (response.getStatusCode().is4xxClientError()) {
			throw new CustomException(response.getBody().getErrors());
		} else {
			throw new ServerException();
		}
	}

	@Override
	public List<Transaction> listTransactions(String accountId, Date fromAccountingDate, Date toAccountingDate) throws CustomException, ServerException {
		LOGGER.info(getUrlTransactions(accountId, fromAccountingDate, toAccountingDate));
		ResponseEntity<Response<TransactionLists>> response = restTemplate.exchange(getUrlTransactions(accountId, fromAccountingDate, toAccountingDate), HttpMethod.GET, new HttpEntity<>(getHttpHeaders()), new ParameterizedTypeReference<Response<TransactionLists>>() {
		});
		if (response.getStatusCode().is2xxSuccessful()) {
			return response.getBody().getPayload().getList();
		} else if (response.getStatusCode().is4xxClientError()) {
			throw new CustomException(response.getBody().getErrors());
		} else {
			throw new ServerException();
		}
	}

	@Override
	public ResponseMoneyTransfer moneyTransfers(String accountId, RequestMoneyTransfer requestMoneyTransfer) throws CustomException, ServerException {
		LOGGER.info(getUrlMoneyTransfer(accountId));
		ResponseEntity<Response<ResponseMoneyTransfer>> response = restTemplate.exchange(getUrlMoneyTransfer(accountId), HttpMethod.POST, new HttpEntity<>(requestMoneyTransfer, getHttpHeadersWithTimeZone()), new ParameterizedTypeReference<Response<ResponseMoneyTransfer>>() {
		});
		if (response.getStatusCode().is2xxSuccessful()) {
			return response.getBody().getPayload();
		} else if (response.getStatusCode().is4xxClientError()) {
			throw new CustomException(response.getBody().getErrors());
		} else {
			throw new ServerException();
		}
	}

}
