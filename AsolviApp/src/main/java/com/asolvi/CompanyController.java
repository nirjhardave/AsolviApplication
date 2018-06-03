package com.asolvi;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/companies")
public class CompanyController {

	private List<Company> companies;


	CompanyController() {
		this.companies = buildCompanies();
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Company> getCompanies() {
		if (this.companies.size() == 0) {
			return Collections.emptyList();
		} else {
			return this.companies;
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Company getCompany(@PathVariable("id") Long id) {
		return this.companies.stream().filter(company -> company.getId() == id).findFirst().get();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Company saveCompany(@RequestBody Company company) {
		Long nextId = 0L;
		if (this.companies.size() != 0) {
			Company lastCompany = this.companies.stream().skip(this.companies.size() - 1).findFirst().get();
			nextId = lastCompany.getId() + 1;
		}

		company.setId(nextId);
		this.companies.add(company);
		return company;

	}

	@RequestMapping(method = RequestMethod.PUT)
	public Company updateCompany(@RequestBody Company company) {
		Company modifiedCompany = this.companies.stream().filter(u -> u.getId() == company.getId()).findFirst().get();
		modifiedCompany.setCompanyName(company.getCompanyName());
		modifiedCompany.setCompanySector(company.getCompanySector());
		modifiedCompany.setCeoEmail(company.getCeoEmail());
		return modifiedCompany;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public boolean deleteCompany(@PathVariable Long id) {
		Company deleteCompany = this.companies.stream().filter(company -> company.getId() == id).findFirst().get();
		if (deleteCompany != null) {
			this.companies.remove(deleteCompany);
			return true;
		} else  {
			return false;
		}


	}

	List<Company> buildCompanies() {
		List<Company> companies = new ArrayList<>();

		Company company1 = buildCompany(1L, "Apple", "Consumer Electronics", "tim.cook@apple.com");
		Company company2 = buildCompany(2L, "Microsoft", "Computer Software", "satya.nadella@microsoft.com");
		Company company3 = buildCompany(3L, "SAS Inc", "Computer Software", "jim.goodnight@sas.com");
		Company company4 = buildCompany(4L, "Asolvi", "Computer Software", "pal.rodseth@asolvi.com");
		Company company5 = buildCompany(5L, "LinkedIn", "Internet", "jeffweiner@linkedin.com");

		companies.add(company1);
		companies.add(company2);
		companies.add(company3);
		companies.add(company4);
		companies.add(company5);

		return companies;

	}

	Company buildCompany(Long id, String companyName, String companySector, String ceoEmail) {
		Company company = new Company();
		company.setId(id);
		company.setCompanyName(companyName);
		company.setCompanySector(companySector);
		company.setCeoEmail(ceoEmail);
		return company;
	}

}