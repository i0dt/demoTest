package it.test.demo.rest.bean;

import java.io.Serializable;

public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	private String accountId;
	private String iban;
	private String abiCode;
	private String cabCode;
	private String countryCode;
	private String internationalCin;
	private String nationalCin;
	private String account;
	private String alias;
	private String productName;
	private String holderName;
	private String activatedDate;
	private String currency;

	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the iban
	 */
	public String getIban() {
		return iban;
	}

	/**
	 * @param iban the iban to set
	 */
	public void setIban(String iban) {
		this.iban = iban;
	}

	/**
	 * @return the abiCode
	 */
	public String getAbiCode() {
		return abiCode;
	}

	/**
	 * @param abiCode the abiCode to set
	 */
	public void setAbiCode(String abiCode) {
		this.abiCode = abiCode;
	}

	/**
	 * @return the cabCode
	 */
	public String getCabCode() {
		return cabCode;
	}

	/**
	 * @param cabCode the cabCode to set
	 */
	public void setCabCode(String cabCode) {
		this.cabCode = cabCode;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the internationalCin
	 */
	public String getInternationalCin() {
		return internationalCin;
	}

	/**
	 * @param internationalCin the internationalCin to set
	 */
	public void setInternationalCin(String internationalCin) {
		this.internationalCin = internationalCin;
	}

	/**
	 * @return the nationalCin
	 */
	public String getNationalCin() {
		return nationalCin;
	}

	/**
	 * @param nationalCin the nationalCin to set
	 */
	public void setNationalCin(String nationalCin) {
		this.nationalCin = nationalCin;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the holderName
	 */
	public String getHolderName() {
		return holderName;
	}

	/**
	 * @param holderName the holderName to set
	 */
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	/**
	 * @return the activatedDate
	 */
	public String getActivatedDate() {
		return activatedDate;
	}

	/**
	 * @param activatedDate the activatedDate to set
	 */
	public void setActivatedDate(String activatedDate) {
		this.activatedDate = activatedDate;
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