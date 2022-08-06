package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.service.SaleService;

@RestController
@RequestMapping(value = "/sales") // valor do caminho/rota que vou acessar
public class SaleController {

	// Controller precisa do service, service precisa do repository
	@Autowired //injeta a instancia 
	private SaleService service;
	
	@GetMapping // uma das  operações que tem na hora de fazer requisição, obter dados do backend
	//controllador recebe os dados como texto e depois converte pra dados ,a na web os dados trafegam como texto, por isso string
	public Page<Sale> findSales(
			@RequestParam(value = "minDate", defaultValue = "") String minDate, 
			@RequestParam(value = "maxDate", defaultValue = "")String maxDate, 
			Pageable pageable) {
		return service.findSales(minDate, maxDate, pageable);
	}
	
}
