package it.test.demo.rest.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import it.test.demo.rest.configurations.ExternalConfig;
import it.test.demo.rest.enums.HeadersExternal;

abstract class ExternalServiceA implements ExternalServiceI {
	@Autowired
	private ExternalConfig externalConfig;
	private final String TAG_ID_ACCOUNT = "{accountId}";

	HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HeadersExternal.AUTH_SCHEMA.getDesc(), externalConfig.getAuthSchema());
		headers.add(HeadersExternal.API_KEY.getDesc(), externalConfig.getApiKey());
		headers.add(HeadersExternal.ID_ACCOUNT.getDesc(), externalConfig.getAccountId());
		headers.add(HeadersExternal.ID_CHIAVE.getDesc(), externalConfig.getIdChiave());
		return headers;
	}
	
	HttpHeaders getHttpHeadersWithTimeZone(){
		HttpHeaders headers = getHttpHeaders();
		headers.add(HeadersExternal.X_TIME_ZONE.getDesc(), "Europe/Rome");
		return headers;
	}

	String getUrlAccount(String accountId) {
		StringBuffer sb = new StringBuffer();
		sb.append(externalConfig.getBaseUrl()).append(externalConfig.getExternalServiceUrl().getUrlAccount());
		return sb.toString().replace(TAG_ID_ACCOUNT, accountId);
	}

	String getUrlBalance(String accountId) {
		StringBuffer sb = new StringBuffer();
		sb.append(externalConfig.getBaseUrl()).append(externalConfig.getExternalServiceUrl().getUrlBalance());
		return sb.toString().replace(TAG_ID_ACCOUNT, accountId);
	}

	String getUrlTransactions(String accountId, Date fromAccountingDate, Date toAccountingDate) {
		StringBuffer sb = new StringBuffer();
		sb.append(externalConfig.getBaseUrl()).append(externalConfig.getExternalServiceUrl().getUrlTransactions());
		sb.append("?fromAccountingDate=").append(getFormatDate(fromAccountingDate));
		sb.append("&toAccountingDate=").append(getFormatDate(toAccountingDate));
		return sb.toString().replace(TAG_ID_ACCOUNT, accountId);
	}
	
	String getUrlMoneyTransfer(String accountId) {
		StringBuffer sb = new StringBuffer();
		sb.append(externalConfig.getBaseUrl()).append(externalConfig.getExternalServiceUrl().getUrlMoneyTransfer());
		return sb.toString().replace(TAG_ID_ACCOUNT, accountId);
	}


	private String getFormatDate(Date date) {
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		simpleDateFormat.applyPattern("yyyy-MM-dd");
		return simpleDateFormat.format(date);
	}

}
