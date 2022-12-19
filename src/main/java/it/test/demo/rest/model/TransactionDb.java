package it.test.demo.rest.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transaction")
public class TransactionDb implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String transactionId;
	private String operationId;
	private String accountingDate;
	private String valueDate;
	private String transactionType;
	private String TransactionTypeValue;
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
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}
	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	/**
	 * @return the transactionTypeValue
	 */
	public String getTransactionTypeValue() {
		return TransactionTypeValue;
	}
	/**
	 * @param transactionTypeValue the transactionTypeValue to set
	 */
	public void setTransactionTypeValue(String transactionTypeValue) {
		TransactionTypeValue = transactionTypeValue;
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
	@Override
	public String toString() {
		return "TransactionDb [transactionId=" + transactionId + ", operationId=" + operationId + ", accountingDate="
				+ accountingDate + ", valueDate=" + valueDate + ", transactionType=" + transactionType
				+ ", TransactionTypeValue=" + TransactionTypeValue + ", amount=" + amount + ", currency=" + currency
				+ ", description=" + description + "]";
	}
}
