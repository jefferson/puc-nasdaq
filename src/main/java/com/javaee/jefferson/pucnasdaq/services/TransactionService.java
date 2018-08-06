package com.javaee.jefferson.pucnasdaq.services;

import java.util.Calendar;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

import com.javaee.jefferson.pucnasdaq.config.EmailConfig;
import com.javaee.jefferson.pucnasdaq.domain.Buyer;
import com.javaee.jefferson.pucnasdaq.domain.Company;
import com.javaee.jefferson.pucnasdaq.domain.Stock;
import com.javaee.jefferson.pucnasdaq.domain.TransactionBuy;
import com.javaee.jefferson.pucnasdaq.domain.TransactionSell;
import com.javaee.jefferson.pucnasdaq.repositories.BuyerRepository;
import com.javaee.jefferson.pucnasdaq.repositories.CompanyRepository;

@Service
public class TransactionService {
	
	private CompanyRepository companyRepository;
	private BuyerRepository buyerRepository;	
	private static EmailConfig emailConfig = new EmailConfig();
	
	public TransactionService(CompanyRepository companyRepository, BuyerRepository buyerRepository)
	{
		this.companyRepository = companyRepository;
		this.buyerRepository = buyerRepository;
	}
	
	public Stock sell(TransactionSell transaction)
	{
		Optional<Company> company = this.companyRepository.findById(transaction.getCompanyId());
		
		Stock stock = company.get().getStocks()
		.parallelStream()
		.filter(x -> x.getId().equals(transaction.getStockId()) )
		.findFirst().orElse(null);
		
		if(stock != null)
		{
			Optional<Buyer> buyer = buyerRepository.findById(transaction.getBuyerId());
			
			String lastBuyer = stock.getBuyer().getEmail();
			String currentBuyer = buyer.get().getEmail();
			
			Calendar c = Calendar.getInstance(TimeZone.getDefault());
						
			stock.setBoughtIn(c.getTime());
			stock.setCurrentValue(transaction.getCurrentValue());
			stock.setBuyer(buyer.get());
			
			emailConfig.sendEmail(lastBuyer, "Venda realizada com sucesso!","A venda foi realizada com sucesso!");
			emailConfig.sendEmail(currentBuyer, "Compra realizada com sucesso!","A compra foi realizada com sucesso!");
			
		}
		else
		{
			throw new IllegalArgumentException("Stock Not Found For ID value: " + transaction.getStockId().toString() );
		}
		
		companyRepository.save(company.get());		
		
		return stock;
	}
	
	public Stock buy(TransactionBuy transaction)
	{
		return null;
	}
	
}
