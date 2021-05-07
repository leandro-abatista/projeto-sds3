package com.cursospringreact.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cursospringreact.dsvendas.dto.SellerDTO;
import com.cursospringreact.dsvendas.entities.Seller;
import com.cursospringreact.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired//injeção de dependência
	private SellerRepository sellerRepository;
	
	public List<SellerDTO> findAll(){
		List<Seller> result = sellerRepository.findAll();
		
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}
