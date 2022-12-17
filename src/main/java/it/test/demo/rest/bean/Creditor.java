package it.test.demo.rest.bean;

import java.io.Serializable;

public class Creditor implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private CreditorAccount account;
	private CreditorAddress address;
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the account
	 */
	public CreditorAccount getAccount() {
		return account;
	}
	/**
	 * @param account the account to set
	 */
	public void setAccount(CreditorAccount account) {
		this.account = account;
	}
	/**
	 * @return the address
	 */
	public CreditorAddress getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(CreditorAddress address) {
		this.address = address;
	}
}
