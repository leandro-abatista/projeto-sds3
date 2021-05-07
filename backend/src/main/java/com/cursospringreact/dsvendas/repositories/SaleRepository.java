package com.cursospringreact.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cursospringreact.dsvendas.dto.SaleSucessDTO;
import com.cursospringreact.dsvendas.dto.SaleSumDTO;
import com.cursospringreact.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	@Query("select new com.cursospringreact.dsvendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ " from Sale as obj group by obj.seller")
	List<SaleSumDTO> amountGroupBySeller();//vendas agrupadas por vendedor
	
	@Query("select new com.cursospringreact.dsvendas.dto.SaleSucessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ " from Sale as obj group by obj.seller")
	List<SaleSucessDTO> sucessGroupBySeller();//vendas agrupadas por vendedor
}
