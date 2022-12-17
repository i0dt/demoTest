package it.test.demo.rest.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import it.test.demo.rest.bean.ResponseErrors;
import it.test.demo.rest.exception.CustomException;

abstract class AccountManagerA implements AccountManagerI {
	Date getDate(String fromAccountingDate) throws CustomException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatter.parse(fromAccountingDate);
		} catch (ParseException e) {
			throw new CustomException(getDateFormatError());
		}
	}

	List<ResponseErrors> getDateFormatError() {
		ResponseErrors responseErrors = new ResponseErrors();
		responseErrors.setCode("XXXX");
		responseErrors.setCode("Input date error");
		return Arrays.asList(responseErrors);
	}
}
