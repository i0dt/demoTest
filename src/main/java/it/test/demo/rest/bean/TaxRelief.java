package it.test.demo.rest.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxRelief implements Serializable {
	private static final long serialVersionUID = 1L;
	private String taxReliefId;
	@JsonProperty("isCondoUpgrade")
	private Boolean condoUpgrade;
	private String creditorFiscalCode;
	private String beneficiaryType;
	private NaturalPersonBeneficiary naturalPersonBeneficiary;
	private LegalPersonBeneficiary legalPersonBeneficiary;

	/**
	 * @return the taxReliefId
	 */
	public String getTaxReliefId() {
		return taxReliefId;
	}

	/**
	 * @param taxReliefId the taxReliefId to set
	 */
	public void setTaxReliefId(String taxReliefId) {
		this.taxReliefId = taxReliefId;
	}

	/**
	 * @return the condoUpgrade
	 */
	public Boolean isCondoUpgrade() {
		return condoUpgrade;
	}

	/**
	 * @param condoUpgrade the condoUpgrade to set
	 */
	public void setCondoUpgrade(Boolean condoUpgrade) {
		this.condoUpgrade = condoUpgrade;
	}

	/**
	 * @return the creditorFiscalCode
	 */
	public String getCreditorFiscalCode() {
		return creditorFiscalCode;
	}

	/**
	 * @param creditorFiscalCode the creditorFiscalCode to set
	 */
	public void setCreditorFiscalCode(String creditorFiscalCode) {
		this.creditorFiscalCode = creditorFiscalCode;
	}

	/**
	 * @return the beneficiaryType
	 */
	public String getBeneficiaryType() {
		return beneficiaryType;
	}

	/**
	 * @param beneficiaryType the beneficiaryType to set
	 */
	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}

	/**
	 * @return the naturalPersonBeneficiary
	 */
	public NaturalPersonBeneficiary getNaturalPersonBeneficiary() {
		return naturalPersonBeneficiary;
	}

	/**
	 * @param naturalPersonBeneficiary the naturalPersonBeneficiary to set
	 */
	public void setNaturalPersonBeneficiary(NaturalPersonBeneficiary naturalPersonBeneficiary) {
		this.naturalPersonBeneficiary = naturalPersonBeneficiary;
	}

	/**
	 * @return the legalPersonBeneficiary
	 */
	public LegalPersonBeneficiary getLegalPersonBeneficiary() {
		return legalPersonBeneficiary;
	}

	/**
	 * @param legalPersonBeneficiary the legalPersonBeneficiary to set
	 */
	public void setLegalPersonBeneficiary(LegalPersonBeneficiary legalPersonBeneficiary) {
		this.legalPersonBeneficiary = legalPersonBeneficiary;
	}

}
