package it.test.demo.rest.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestMoneyTransfer implements Serializable {
	private static final long serialVersionUID = 1L;
	private Creditor creditor;
	private String executionDate;
	private String uri;
	private String description;
	private Double amount;
	private String currency;
	@JsonProperty("isUrgent")
	private Boolean urgent;
	@JsonProperty("isInstant")
	private Boolean instance;
	private String feeType;
	private String feeAccountId;
	private TaxRelief taxRelief;

	/**
	 * @return the creditor
	 */
	public Creditor getCreditor() {
		return creditor;
	}

	/**
	 * @param creditor the creditor to set
	 */
	public void setCreditor(Creditor creditor) {
		this.creditor = creditor;
	}

	/**
	 * @return the executionDate
	 */
	public String getExecutionDate() {
		return executionDate;
	}

	/**
	 * @param executionDate the executionDate to set
	 */
	public void setExecutionDate(String executionDate) {
		this.executionDate = executionDate;
	}

	/**
	 * @return the uri
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * @param uri the uri to set
	 */
	public void setUri(String uri) {
		this.uri = uri;
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
	public Double getAmount() {
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

	/**
	 * @return the urgent
	 */
	public Boolean isUrgent() {
		return urgent;
	}

	/**
	 * @param urgent the urgent to set
	 */
	public void setUrgent(Boolean urgent) {
		this.urgent = urgent;
	}

	/**
	 * @return the instance
	 */
	public Boolean isInstance() {
		return instance;
	}

	/**
	 * @param instance the instance to set
	 */
	public void setInstance(Boolean instance) {
		this.instance = instance;
	}

	/**
	 * @return the feeType
	 */
	public String getFeeType() {
		return feeType;
	}

	/**
	 * @param feeType the feeType to set
	 */
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	/**
	 * @return the feeAccountId
	 */
	public String getFeeAccountId() {
		return feeAccountId;
	}

	/**
	 * @param feeAccountId the feeAccountId to set
	 */
	public void setFeeAccountId(String feeAccountId) {
		this.feeAccountId = feeAccountId;
	}

	/**
	 * @return the taxRelief
	 */
	public TaxRelief getTaxRelief() {
		return taxRelief;
	}

	/**
	 * @param taxRelief the taxRelief to set
	 */
	public void setTaxRelief(TaxRelief taxRelief) {
		this.taxRelief = taxRelief;
	}

}
