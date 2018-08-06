package com.javaee.jefferson.pucnasdaq.services;

import java.util.Set;

import com.javaee.jefferson.pucnasdaq.domain.Buyer;

public interface BuyerService {

	Set<Buyer> getAll();

	Buyer getBuyerById(String id);

	Buyer createNewBuyer(Buyer buyer);

	Buyer saveBuyer(String id, Buyer buyer);

	void deleteBuyerById(String id);
	
}
