package it.test.demo.rest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpHeaders;

import it.test.demo.rest.bean.RequestMoneyTransfer;
import it.test.demo.rest.bean.TaxRelief;
import it.test.demo.rest.enums.ErrorEnum;
import it.test.demo.rest.exception.CustomException;

abstract class RestServiceA implements RestServiceI {
	
	HttpHeaders httpHeaders() {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("X-Time-Zone", "Europe/Rome");
		return responseHeaders;
	}
	
	void validateAccountInput(String accountId) throws CustomException {
		valideAccountId(accountId);
	}

	void validateBalanceInput(String accountId) throws CustomException {
		valideAccountId(accountId);
	}

	void validateTransactionsInput(String accountId, String fromAccountingDate, String toAccountingDate) throws CustomException {
		valideAccountId(accountId);
		Date from = validateDate(fromAccountingDate);
		Date to = validateDate(toAccountingDate);
		validateDate(from, to);
	}

	void validateDate(Date from, Date to) throws CustomException {
		if(from.after(to)) {
			throw new CustomException(ErrorEnum.REQ017);
		}
	}

	void validateMoneyTransferInput(String accountId, RequestMoneyTransfer requestMoneyTransfer) throws CustomException {
		valideAccountId(accountId);
		validateRequestMoneyTransfer(requestMoneyTransfer);
	}

	private void validateRequestMoneyTransfer(RequestMoneyTransfer requestMoneyTransfer) throws CustomException {
		if(requestMoneyTransfer.getCreditor() == null
				|| requestMoneyTransfer.getCreditor().getName() == null
				|| requestMoneyTransfer.getCreditor().getAccount() == null
				|| requestMoneyTransfer.getCreditor().getAccount().getAccountCode() == null
				|| requestMoneyTransfer.getDescription() == null
				|| requestMoneyTransfer.getAmount() == null
				|| requestMoneyTransfer.getCurrency() == null) {
			throw new CustomException(ErrorEnum.REQ010);
		}
		
		if(requestMoneyTransfer.getTaxRelief() != null) {
			TaxRelief taxRelief = requestMoneyTransfer.getTaxRelief();
			if(taxRelief.isCondoUpgrade() == null 
					|| taxRelief.getBeneficiaryType() == null) {
				throw new CustomException(ErrorEnum.REQ010);
			}
			
			if(taxRelief.getNaturalPersonBeneficiary() != null) {
				if(taxRelief.getNaturalPersonBeneficiary().getFiscalCode1() == null 
						|| taxRelief.getBeneficiaryType() == null) {
					throw new CustomException(ErrorEnum.REQ010);
				}
			}
			
			if(taxRelief.getLegalPersonBeneficiary() != null) {
				if(taxRelief.getLegalPersonBeneficiary().getFiscalCode() == null) {
					throw new CustomException(ErrorEnum.REQ010);
				}
			}
		}
		
		//TODO: add other validate, example: FiscalCode
	}

	private void valideAccountId(String accountId) throws CustomException {
		try {
			Long.parseLong(accountId);
		} catch (Exception e) {
			throw new CustomException(ErrorEnum.REQ004);
		}
	}

	private Date validateDate(String date) throws CustomException {
		if (date == null || date.length() != 10) {
			throw new CustomException(ErrorEnum.REQ017);
		}
		try {
			final SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
			simpleDateFormat.applyPattern("yyyy-MM-dd");
			return simpleDateFormat.parse(date);
		} catch (Exception e) {
			throw new CustomException(ErrorEnum.REQ017);
		}
	}

	private String getFormatDate(Date date) {
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		simpleDateFormat.applyPattern("yyyy-MM-dd");
		return simpleDateFormat.format(date);
	}

}