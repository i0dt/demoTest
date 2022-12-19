package it.test.demo.rest.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import it.test.demo.rest.bean.Transaction;
import it.test.demo.rest.enums.ErrorEnum;
import it.test.demo.rest.exception.CustomException;
import it.test.demo.rest.model.TransactionDb;

abstract class AccountManagerA implements AccountManagerI {
	Date getDate(String fromAccountingDate) throws CustomException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatter.parse(fromAccountingDate);
		} catch (ParseException e) {
			throw new CustomException(ErrorEnum.REQ017);
		}
	}

	TransactionDb mapTransactionDb(Transaction transaction) {
		final TransactionDb transactionDb = new TransactionDb();
		transactionDb.setAccountingDate(transaction.getAccountingDate());
		transactionDb.setAmount(transaction.getAmount());
		transactionDb.setCurrency(transaction.getCurrency());
		transactionDb.setDescription(transaction.getCurrency());
		transactionDb.setOperationId(transaction.getOperationId());
		transactionDb.setTransactionId(transaction.getTransactionId());
		if (transaction.getType() != null) {
			transactionDb.setTransactionType(transaction.getType().getEnumeration());
			transactionDb.setTransactionTypeValue(transaction.getType().getValue());
		}
		transactionDb.setValueDate(transaction.getValueDate());
		return transactionDb;
	}
}
