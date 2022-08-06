package com.devsuperior.dsmeta.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@GetMapping
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		//converte os textos para o tipo localDate
		LocalDate min = minDate.equals("")? today.minusDays(365): LocalDate.parse(minDate); // traz um ano atras
		LocalDate max = minDate.equals("")? today: LocalDate.parse(maxDate); // traz a data atual
		
		
		
		return repository.findSales(min, max, pageable);
		
	}

}
