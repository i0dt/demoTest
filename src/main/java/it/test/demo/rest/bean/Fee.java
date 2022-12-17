package it.test.demo.rest.bean;

import java.io.Serializable;

public class Fee implements Serializable {
	private static final long serialVersionUID = 1L;
	private String feeCode;
	private String description;
	private double amount;
	private String currency;

	/**
	 * @return the feeCode
	 */
	public String getFeeCode() {
		return feeCode;
	}

	/**
	 * @param feeCode the feeCode to set
	 */
	public void setFeeCode(String feeCode) {
		this.feeCode = feeCode;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

}