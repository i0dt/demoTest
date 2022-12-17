package it.test.demo.rest.bean;

import java.io.Serializable;

public class Amount implements Serializable {
	private static final long serialVersionUID = 1L;
    private double debtorAmount;
    private String debtorCurrency;
    private double creditorAmount;
    private String creditorCurrency;
    private String creditorCurrencyDate;
    private int exchangeRate;
	/**
	 * @return the debtorAmount
	 */
	public double getDebtorAmount() {
		return debtorAmount;
	}
	/**
	 * @param debtorAmount the debtorAmount to set
	 */
	public void setDebtorAmount(double debtorAmount) {
		this.debtorAmount = debtorAmount;
	}
	/**
	 * @return the debtorCurrency
	 */
	public String getDebtorCurrency() {
		return debtorCurrency;
	}
	/**
	 * @param debtorCurrency the debtorCurrency to set
	 */
	public void setDebtorCurrency(String debtorCurrency) {
		this.debtorCurrency = debtorCurrency;
	}
	/**
	 * @return the creditorAmount
	 */
	public double getCreditorAmount() {
		return creditorAmount;
	}
	/**
	 * @param creditorAmount the creditorAmount to set
	 */
	public void setCreditorAmount(double creditorAmount) {
		this.creditorAmount = creditorAmount;
	}
	/**
	 * @return the creditorCurrency
	 */
	public String getCreditorCurrency() {
		return creditorCurrency;
	}
	/**
	 * @param creditorCurrency the creditorCurrency to set
	 */
	public void setCreditorCurrency(String creditorCurrency) {
		this.creditorCurrency = creditorCurrency;
	}
	/**
	 * @return the creditorCurrencyDate
	 */
	public String getCreditorCurrencyDate() {
		return creditorCurrencyDate;
	}
	/**
	 * @param creditorCurrencyDate the creditorCurrencyDate to set
	 */
	public void setCreditorCurrencyDate(String creditorCurrencyDate) {
		this.creditorCurrencyDate = creditorCurrencyDate;
	}
	/**
	 * @return the exchangeRate
	 */
	public int getExchangeRate() {
		return exchangeRate;
	}
	/**
	 * @param exchangeRate the exchangeRate to set
	 */
	public void setExchangeRate(int exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

    
}
