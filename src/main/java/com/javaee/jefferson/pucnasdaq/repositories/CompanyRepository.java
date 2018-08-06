package com.javaee.jefferson.pucnasdaq.repositories;

import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaee.jefferson.pucnasdaq.domain.Company;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String>{
	Set<Company> findByName(String name);
}
