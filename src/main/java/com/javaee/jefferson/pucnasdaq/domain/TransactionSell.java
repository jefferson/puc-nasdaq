package com.javaee.jefferson.pucnasdaq.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionSell implements Serializable {

	private String companyId;
	private String buyerId;
	private String stockId;	
	private BigDecimal currentValue;
	
}

