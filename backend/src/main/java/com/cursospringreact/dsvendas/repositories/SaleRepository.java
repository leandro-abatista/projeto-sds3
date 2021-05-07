package com.cursospringreact.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursospringreact.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	
}
