package com.asolvi;

public class Company {

	private Long id;
	private String companyName;
	private String companySector;
	private String ceoEmail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanySector() {
		return companySector;
	}

	public void setCompanySector(String companySector) {
		this.companySector = companySector;
	}

	public String getCeoEmail() {
		return ceoEmail;
	}

	public void setCeoEmail(String ceoEmail) {
		this.ceoEmail = ceoEmail;
	}
}