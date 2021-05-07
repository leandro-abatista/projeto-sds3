package com.cursospringreact.dsvendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursospringreact.dsvendas.dto.SaleDTO;
import com.cursospringreact.dsvendas.services.SaleService;

@RestController//controlador REST
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService SaleService;

	/**
	 * Busca paginada de vendas com spring jpa
	 * @param pageable
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> list = SaleService.findAll(pageable);
		return ResponseEntity.ok(list);
	}
}
