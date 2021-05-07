package com.cursospringreact.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cursospringreact.dsvendas.dto.SaleDTO;
import com.cursospringreact.dsvendas.dto.SaleSucessDTO;
import com.cursospringreact.dsvendas.dto.SaleSumDTO;
import com.cursospringreact.dsvendas.entities.Sale;
import com.cursospringreact.dsvendas.repositories.SaleRepository;
import com.cursospringreact.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private SellerRepository sellerRepository;

	/**
	 * Busca paginada de vendas com spring
	 * @param pageable
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		//busca a lista de vendedores e salva em memória, assim o jpa entende que não precisa buscar determinado vendedor
		sellerRepository.findAll();
		
		Page<Sale> result = saleRepository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupBySeller(){
		return saleRepository.amountGroupBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSucessDTO> sucessGroupBySeller(){
		return saleRepository.sucessGroupBySeller();
	}
}
