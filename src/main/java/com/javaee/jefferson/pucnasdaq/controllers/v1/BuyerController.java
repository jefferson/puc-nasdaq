package com.javaee.jefferson.pucnasdaq.controllers.v1;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaee.jefferson.pucnasdaq.domain.Buyer;
import com.javaee.jefferson.pucnasdaq.services.BuyerService;

@RestController
@RequestMapping(BuyerController.BASE_URL)
public class BuyerController {

	public static final String BASE_URL = "/api/v1/buyers";
	
	private final BuyerService buyerService;
	
	public BuyerController(BuyerService buyerService)
	{
		this.buyerService = buyerService;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Set<Buyer> getAll()
	{
		return buyerService.getAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Buyer create(@RequestBody Buyer buyer)
	{
		return buyerService.createNewBuyer(buyer);
	}
}
