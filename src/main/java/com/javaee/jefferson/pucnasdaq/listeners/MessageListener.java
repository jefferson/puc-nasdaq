package com.javaee.jefferson.pucnasdaq.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.javaee.jefferson.pucnasdaq.config.EmailConfig;
import com.javaee.jefferson.pucnasdaq.config.RabbitMQConfig;
import com.javaee.jefferson.pucnasdaq.domain.Message;
import com.javaee.jefferson.pucnasdaq.domain.Stock;
import com.javaee.jefferson.pucnasdaq.services.TransactionService;

@Component
public class MessageListener {

	static final Logger logger = LoggerFactory.getLogger(MessageListener.class);
	
	private static EmailConfig emailConfig = new EmailConfig();
	private final TransactionService transactionService;
	
	public MessageListener( TransactionService transactionService)
	{
		this.transactionService = transactionService;
	}
	
	@RabbitListener(queues = RabbitMQConfig.QUEUE_MESSAGES)
	public void processMessage(Message message)
	{
		logger.info("Message reiceved");
		logger.info("Subject:" + message.getSubject().toString());
		logger.info("Body" + message.getBody().toString());
		
		Stock stock = this.transactionService.sell(message.getTransactionSell());
		
		logger.info("Stock seller processed with sucess: " + stock.getId());
		
	}
	
}
