package com.javaee.jefferson.pucnasdaq.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.javaee.jefferson.pucnasdaq.config.RabbitMQConfig;
import com.javaee.jefferson.pucnasdaq.domain.Message;

@Service
public class MessageServiceImpl implements MessageService{

	private final RabbitTemplate rabbitTemplate;
	
	public MessageServiceImpl(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	@Override
	public void sendMessage(Message message) {

		this.rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_MESSAGES, message);
	}

}
