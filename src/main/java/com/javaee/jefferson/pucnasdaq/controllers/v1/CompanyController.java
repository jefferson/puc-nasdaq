package com.javaee.jefferson.pucnasdaq.controllers.v1;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaee.jefferson.pucnasdaq.domain.Company;
import com.javaee.jefferson.pucnasdaq.services.CompanyService;

@RestController
@RequestMapping(CompanyController.BASE_URL)
public class CompanyController {

	public static final String BASE_URL = "/api/v1/companies";
	
	private final CompanyService companyService;
	
	public CompanyController(CompanyService companyService)
	{
		this.companyService = companyService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Set<Company> getAll()
	{
		return companyService.getAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Company create(@RequestBody Company company)
	{
		return companyService.createNewCompany(company);
	}
	
	@PutMapping({"/{id}"})
	@ResponseStatus(HttpStatus.OK)
	public Company update(@PathVariable String id, @RequestBody Company company)
	{
		return companyService.saveCompany(id, company);
	}

}
