package it.test.demo.rest.bean;

import java.io.Serializable;

public class CreditorAccount implements Serializable {
	private static final long serialVersionUID = 1L;
	private String accountCode;
	private String bicCode;
	/**
	 * @return the accountCode
	 */
	public String getAccountCode() {
		return accountCode;
	}
	/**
	 * @param accountCode the accountCode to set
	 */
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	/**
	 * @return the bicCode
	 */
	public String getBicCode() {
		return bicCode;
	}
	/**
	 * @param bicCode the bicCode to set
	 */
	public void setBicCode(String bicCode) {
		this.bicCode = bicCode;
	}
	
}
