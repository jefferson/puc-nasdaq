package com.javaee.jefferson.pucnasdaq.services;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.jefferson.pucnasdaq.domain.Buyer;
import com.javaee.jefferson.pucnasdaq.domain.Company;
import com.javaee.jefferson.pucnasdaq.domain.Stock;
import com.javaee.jefferson.pucnasdaq.repositories.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService{

	private CompanyRepository companyRepository;
	
	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public Set<Company> getAll() {
		Set<Company> companies = new HashSet<>();
		this.companyRepository.findAll().iterator().forEachRemaining(companies::add);
		return companies;
	}

	@Override
	public Company getCompanyById(String id) {
		return getById(id);
	}

	private Company getById(String id) {
		Optional<Company> companyOptional = companyRepository.findById(id);

        if (!companyOptional.isPresent()) {
            throw new IllegalArgumentException("Company Not Found For ID value: " + id.toString() );
        }
        return companyOptional.get();
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Company createNewCompany(Company company) {
		if(companyRepository.findByName(company.getName()).isEmpty()) {			
			
			if(company.getStocks().size() > company.getMaxStocks())
				throw new IllegalArgumentException("The numbers of stocks must to be less or equal than " + company.getMaxStocks());
			
		
			return companyRepository.save(company);
			
		}else {
			throw new IllegalArgumentException("Company Already Exists with name: " + company.getName());
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Company saveCompany(String id, Company company) {
		
		Company test = getById(id);
		
		company.setId(id);
		
		if(company.getMaxStocks() < test.getMaxStocks() || company.getStocks().size() < test.getStocks().size())
			throw new IllegalArgumentException("The numbers of stocks must to be more than " + test.getMaxStocks());
		
		Company companySaved = companyRepository.save(company);
		
		return companySaved;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteCompanyById(String id) {
		companyRepository.deleteById(id);
	}
	
}
