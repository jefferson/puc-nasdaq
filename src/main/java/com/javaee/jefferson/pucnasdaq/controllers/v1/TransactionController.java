package com.javaee.jefferson.pucnasdaq.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaee.jefferson.pucnasdaq.domain.Message;
import com.javaee.jefferson.pucnasdaq.domain.Stock;
import com.javaee.jefferson.pucnasdaq.domain.TransactionBuy;
import com.javaee.jefferson.pucnasdaq.domain.TransactionSell;
import com.javaee.jefferson.pucnasdaq.services.MessageService;
import com.javaee.jefferson.pucnasdaq.services.TransactionService;

@RestController
@RequestMapping(TransactionController.BASE_URL)
public class TransactionController {
	
	public static final String BASE_URL = "/api/v1/transactions";
	
	private final TransactionService transactionService;
	private final MessageService messageService;
	
	public TransactionController(TransactionService transactionService, MessageService messageService)
	{
		this.transactionService = transactionService;
		this.messageService = messageService;
	}
	
	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Stock Buy(@RequestBody TransactionBuy transaction)
	{
		return this.transactionService.buy(transaction);
	}
	
	@RequestMapping(value = "/sell", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public String Sell(@RequestBody TransactionSell transaction)
	{
		Message message = new Message();
		message.setBody("transaction for company: " + transaction.getCompanyId().toString());
		message.setSubject("new transaction");
		message.setTransactionSell(transaction);
		
		this.messageService.sendMessage(message);
		
		return "Transaction ok";
		
		
	}
}
