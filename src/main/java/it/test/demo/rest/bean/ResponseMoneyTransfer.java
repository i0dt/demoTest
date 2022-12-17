package it.test.demo.rest.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseMoneyTransfer implements Serializable {
	private static final long serialVersionUID = 1L;
	private String  moneyTransferId;
	private String status;
	private String direction;
	private Creditor creditor;
	private Creditor debtor;
	private String cro;
	private String uri;
	private String trn;
	private String description;
	private String createdDatetime;
	private String accountedDatetime;
	private String debtorValueDate;
	private String creditorValueDate;
	private Amount amount;
	@JsonProperty("isUrgent")
	private boolean urgent;
	@JsonProperty("isInstant")
	private boolean instance;
	private String feeType;
	private String feeAccountId;
	private List<Fee> fees;
	@JsonProperty("hasTaxRelief")
	private boolean taxRelief;
	/**
	 * @return the moneyTransferId
	 */
	public String getMoneyTransferId() {
		return moneyTransferId;
	}
	/**
	 * @param moneyTransferId the moneyTransferId to set
	 */
	public void setMoneyTransferId(String moneyTransferId) {
		this.moneyTransferId = moneyTransferId;
	}
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
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}
	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}
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
	 * @return the debtor
	 */
	public Creditor getDebtor() {
		return debtor;
	}
	/**
	 * @param debtor the debtor to set
	 */
	public void setDebtor(Creditor debtor) {
		this.debtor = debtor;
	}
	/**
	 * @return the cro
	 */
	public String getCro() {
		return cro;
	}
	/**
	 * @param cro the cro to set
	 */
	public void setCro(String cro) {
		this.cro = cro;
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
	 * @return the trn
	 */
	public String getTrn() {
		return trn;
	}
	/**
	 * @param trn the trn to set
	 */
	public void setTrn(String trn) {
		this.trn = trn;
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
	 * @return the createdDatetime
	 */
	public String getCreatedDatetime() {
		return createdDatetime;
	}
	/**
	 * @param createdDatetime the createdDatetime to set
	 */
	public void setCreatedDatetime(String createdDatetime) {
		this.createdDatetime = createdDatetime;
	}
	/**
	 * @return the accountedDatetime
	 */
	public String getAccountedDatetime() {
		return accountedDatetime;
	}
	/**
	 * @param accountedDatetime the accountedDatetime to set
	 */
	public void setAccountedDatetime(String accountedDatetime) {
		this.accountedDatetime = accountedDatetime;
	}
	/**
	 * @return the debtorValueDate
	 */
	public String getDebtorValueDate() {
		return debtorValueDate;
	}
	/**
	 * @param debtorValueDate the debtorValueDate to set
	 */
	public void setDebtorValueDate(String debtorValueDate) {
		this.debtorValueDate = debtorValueDate;
	}
	/**
	 * @return the creditorValueDate
	 */
	public String getCreditorValueDate() {
		return creditorValueDate;
	}
	/**
	 * @param creditorValueDate the creditorValueDate to set
	 */
	public void setCreditorValueDate(String creditorValueDate) {
		this.creditorValueDate = creditorValueDate;
	}
	/**
	 * @return the amount
	 */
	public Amount getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	/**
	 * @return the urgent
	 */
	public boolean isUrgent() {
		return urgent;
	}
	/**
	 * @param urgent the urgent to set
	 */
	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}
	/**
	 * @return the instance
	 */
	public boolean isInstance() {
		return instance;
	}
	/**
	 * @param instance the instance to set
	 */
	public void setInstance(boolean instance) {
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
	 * @return the fees
	 */
	public List<Fee> getFees() {
		return fees;
	}
	/**
	 * @param fees the fees to set
	 */
	public void setFees(List<Fee> fees) {
		this.fees = fees;
	}
	/**
	 * @return the taxRelief
	 */
	public boolean isTaxRelief() {
		return taxRelief;
	}
	/**
	 * @param taxRelief the taxRelief to set
	 */
	public void setTaxRelief(boolean taxRelief) {
		this.taxRelief = taxRelief;
	}
}
