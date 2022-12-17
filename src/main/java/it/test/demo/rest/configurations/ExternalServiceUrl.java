package it.test.demo.rest.configurations;

public class ExternalServiceUrl {
	private String urlAccount;
	private String urlBalance;
	private String urlTransactions;
	private String urlMoneyTransfer;

	/**
	 * @return the urlAccount
	 */
	public String getUrlAccount() {
		return urlAccount;
	}

	/**
	 * @param urlAccount the urlAccount to set
	 */
	public void setUrlAccount(String urlAccount) {
		this.urlAccount = urlAccount;
	}

	/**
	 * @return the urlBalance
	 */
	public String getUrlBalance() {
		return urlBalance;
	}

	/**
	 * @param urlBalance the urlBalance to set
	 */
	public void setUrlBalance(String urlBalance) {
		this.urlBalance = urlBalance;
	}

	/**
	 * @return the urlTransactions
	 */
	public String getUrlTransactions() {
		return urlTransactions;
	}

	/**
	 * @param urlTransactions the urlTransactions to set
	 */
	public void setUrlTransactions(String urlTransactions) {
		this.urlTransactions = urlTransactions;
	}

	/**
	 * @return the urlMoneyTransfer
	 */
	public String getUrlMoneyTransfer() {
		return urlMoneyTransfer;
	}

	/**
	 * @param urlMoneyTransfer the urlMoneyTransfer to set
	 */
	public void setUrlMoneyTransfer(String urlMoneyTransfer) {
		this.urlMoneyTransfer = urlMoneyTransfer;
	}

}
