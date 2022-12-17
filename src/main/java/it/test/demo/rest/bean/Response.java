package it.test.demo.rest.bean;

import java.io.Serializable;
import java.util.List;

public class Response<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String status;
	private List<ResponseErrors> errors;
	private T payload;

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the errors
	 */
	public List<ResponseErrors> getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<ResponseErrors> errors) {
		this.errors = errors;
	}

	/**
	 * @return the payload
	 */
	public T getPayload() {
		return payload;
	}

	/**
	 * @param payload the payload to set
	 */
	public void setPayload(T payload) {
		this.payload = payload;
	}
}
