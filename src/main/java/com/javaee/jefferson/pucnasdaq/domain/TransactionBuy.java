package com.javaee.jefferson.pucnasdaq.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionBuy {

	
	private String companyId;
	private String sellerId;
	private String buyerId;
	private String stockId;		
	
	
}

