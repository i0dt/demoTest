package it.test.demo.rest.bean;

import java.io.Serializable;

public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;
	private String transactionId;
	private String operationId;
	private String accountingDate;
	private String valueDate;
	private TransactionType type;
	private double amount;
	private String currency;
	private String description;
	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	/**
	 * @return the operationId
	 */
	public String getOperationId() {
		return operationId;
	}
	/**
	 * @param operationId the operationId to set
	 */
	public void setOperationId(String operationId) {
		this.operationId = operationId;
	}
	/**
	 * @return the accountingDate
	 */
	public String getAccountingDate() {
		return accountingDate;
	}
	/**
	 * @param accountingDate the accountingDate to set
	 */
	public void setAccountingDate(String accountingDate) {
		this.accountingDate = accountingDate;
	}
	/**
	 * @return the valueDate
	 */
	public String getValueDate() {
		return valueDate;
	}
	/**
	 * @param valueDate the valueDate to set
	 */
	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}
	/**
	 * @return the type
	 */
	public TransactionType getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(TransactionType type) {
		this.type = type;
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
}
