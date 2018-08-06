package com.javaee.jefferson.pucnasdaq.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.jefferson.pucnasdaq.domain.Buyer;
import com.javaee.jefferson.pucnasdaq.repositories.BuyerRepository;

@Service
public class BuyerServiceImpl implements BuyerService{

	private BuyerRepository buyerRepository;
	
	public BuyerServiceImpl(BuyerRepository buyerRepository) {
		this.buyerRepository = buyerRepository;
	}

	@Override
	public Set<Buyer> getAll() {
		Set<Buyer> buyers = new HashSet<>();
		this.buyerRepository.findAll().iterator().forEachRemaining(buyers::add);
		return buyers;
	}

	@Override
	public Buyer getBuyerById(String id) {
		return getById(id);
	}

	private Buyer getById(String id) {
		Optional<Buyer> buyerOptional = buyerRepository.findById(id);

        if (!buyerOptional.isPresent()) {
            throw new IllegalArgumentException("Buyer Not Found For ID value: " + id.toString() );
        }
        return buyerOptional.get();
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Buyer createNewBuyer(Buyer buyer) {
		if(buyerRepository.findByName(buyer.getName()).isEmpty()) {			
			return buyerRepository.save(buyer);
		}else {
			throw new IllegalArgumentException("Buyer Already Exists with name: " + buyer.getName());
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Buyer saveBuyer(String id, Buyer buyer) {
		
		buyer.setId(id);
		Buyer buyerSaved = buyerRepository.save(buyer);
		
		return buyerSaved;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteBuyerById(String id) {
		buyerRepository.deleteById(id);
	}
	
}
