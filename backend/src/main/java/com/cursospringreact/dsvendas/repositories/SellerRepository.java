package com.cursospringreact.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursospringreact.dsvendas.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}
