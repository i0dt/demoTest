package it.test.demo.rest.bean;

import java.io.Serializable;

public class LegalPersonBeneficiary implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fiscalCode;
	private String legalRepresentativeFiscalCode;

	/**
	 * @return the fiscalCode
	 */
	public String getFiscalCode() {
		return fiscalCode;
	}

	/**
	 * @param fiscalCode the fiscalCode to set
	 */
	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}

	/**
	 * @return the legalRepresentativeFiscalCode
	 */
	public String getLegalRepresentativeFiscalCode() {
		return legalRepresentativeFiscalCode;
	}

	/**
	 * @param legalRepresentativeFiscalCode the legalRepresentativeFiscalCode to set
	 */
	public void setLegalRepresentativeFiscalCode(String legalRepresentativeFiscalCode) {
		this.legalRepresentativeFiscalCode = legalRepresentativeFiscalCode;
	}

}
