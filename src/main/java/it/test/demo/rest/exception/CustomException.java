package it.test.demo.rest.exception;

import java.util.ArrayList;
import java.util.List;

import it.test.demo.rest.bean.ResponseErrors;
import it.test.demo.rest.enums.ErrorEnum;

public class CustomException extends Exception {
	private static final long serialVersionUID = 1L;
	private List<ResponseErrors> errors = new ArrayList<ResponseErrors>();

	public CustomException(List<ResponseErrors> errors) {
		super(errors.get(0).getDescription());
		setErrors(errors);
	}

	public CustomException(String message) {
		super(message);
		ResponseErrors responseErrors = new ResponseErrors();
		responseErrors.setCode(ErrorEnum.XXX001.name());
		responseErrors.setDescription(message);
		getErrors().add(responseErrors);
	}
	
	public CustomException(ErrorEnum errorEnum) {
		super(errorEnum.getDesc());
		ResponseErrors responseErrors = new ResponseErrors();
		responseErrors.setCode(errorEnum.name());
		responseErrors.setDescription(errorEnum.getDesc());
		getErrors().add(responseErrors);
	}
	
	public CustomException(String code, String description) {
		super(description);
		ResponseErrors responseErrors = new ResponseErrors();
		responseErrors.setCode(code);
		responseErrors.setDescription(description);
		getErrors().add(responseErrors);
	}

	public CustomException(String message, Throwable cause) {
		super(message, cause);
		ResponseErrors responseErrors = new ResponseErrors();
		responseErrors.setCode(ErrorEnum.XXX002.name());
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
