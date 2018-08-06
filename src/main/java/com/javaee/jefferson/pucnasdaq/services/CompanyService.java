package com.javaee.jefferson.pucnasdaq.services;

import java.util.Set;

import com.javaee.jefferson.pucnasdaq.domain.Company;

public interface CompanyService {

	Set<Company> getAll();

	Company getCompanyById(String id);

	Company createNewCompany(Company company);

	Company saveCompany(String id, Company company);

	void deleteCompanyById(String id);
	
}
