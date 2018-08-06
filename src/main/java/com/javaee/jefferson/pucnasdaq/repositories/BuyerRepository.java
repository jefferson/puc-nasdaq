package com.javaee.jefferson.pucnasdaq.repositories;

import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaee.jefferson.pucnasdaq.domain.Buyer;

@Repository
public interface BuyerRepository extends MongoRepository<Buyer, String>{
	Set<Buyer> findByName(String name);
}
