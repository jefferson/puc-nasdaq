package com.javaee.jefferson.pucnasdaq.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stock {

	private String id = UUID.randomUUID().toString();
	
	private String name;
	
	private Date boughtIn;	
	private BigDecimal initialValue;
	private BigDecimal currentValue;
	
	private Buyer buyer;
	
}
