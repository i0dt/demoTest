package it.test.demo.rest.exception;

import java.util.ArrayList;
import java.util.List;

import it.test.demo.rest.bean.ResponseErrors;
import it.test.demo.rest.enums.ErrorEnum;

public class ServerException extends Exception {
	private static final long serialVersionUID = 1L;
	private List<ResponseErrors> errors;

	public ServerException() {
		super();
		ResponseErrors responseErrors = new ResponseErrors();
		responseErrors.setCode(ErrorEnum.ZZZ001.name());
		responseErrors.setDescription(ErrorEnum.ZZZ001.getDesc());
		getErrors().add(responseErrors);
	}

	public ServerException(String code, String description) {
		super(description);
		ResponseErrors responseErrors = new ResponseErrors();
		responseErrors.setCode(code);
		responseErrors.setDescription(description);
		getErrors().add(responseErrors);
	}
	
	public ServerException(String message) {
		super(message);
		ResponseErrors responseErrors = new ResponseErrors();
		responseErrors.setCode(ErrorEnum.ZZZ002.name());
		responseErrors.setDescription(message);
		getErrors().add(responseErrors);
	}

	public ServerException(String message, Throwable cause) {
		super(message, cause);
		ResponseErrors responseErrors = new ResponseErrors();
		responseErrors.setCode(ErrorEnum.ZZZ003.name());
		responseErrors.setDescription(message);
		getErrors().add(responseErrors);
	}

	/**
	 * @return the errors
	 */
	public List<ResponseErrors> getErrors() {
		if (errors == null) {
			errors = new ArrayList<ResponseErrors>();
		}
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<ResponseErrors> errors) {
		this.errors = errors;
	}

}
