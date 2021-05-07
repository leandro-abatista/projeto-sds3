package com.cursospringreact.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursospringreact.dsvendas.dto.SaleDTO;
import com.cursospringreact.dsvendas.dto.SaleSucessDTO;
import com.cursospringreact.dsvendas.dto.SaleSumDTO;
import com.cursospringreact.dsvendas.services.SaleService;

@RestController//controlador REST
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService saleService;

	/**
	 * Busca paginada de vendas com spring jpa
	 * @param pageable
	 * @return
	 */
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> list = saleService.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/sum-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupBySeller(){
		List<SaleSumDTO> list = saleService.amountGroupBySeller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/sucess-by-seller")
	public ResponseEntity<List<SaleSucessDTO>> sucessGroupBySeller(){
		List<SaleSucessDTO> list = saleService.sucessGroupBySeller();
		return ResponseEntity.ok(list);
	}
}
