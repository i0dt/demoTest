package it.test.demo.rest.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TransactionLists implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Transaction> list;
	/**
	 * @return the list
	 */
	public List<Transaction> getList() {
		if(list == null)
			list = new ArrayList<Transaction>();
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List<Transaction> list) {
		this.list = list;
	}
	

}
