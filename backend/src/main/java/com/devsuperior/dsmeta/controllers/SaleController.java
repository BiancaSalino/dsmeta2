package com.devsuperior.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.service.SaleService;

@RestController
@RequestMapping(value = "/sales") // valor do caminho/rota que vou acessar
public class SaleController {

	// Controller precisa do service, service precisa do repository
	@Autowired //injeta a instancia 
	private SaleService service;
	
	@GetMapping // uma das  operações que tem na hora de fazer requisição; obter dados do backend
	public List<Sale> findSales() {
		return service.findSales();
	}
	
}
