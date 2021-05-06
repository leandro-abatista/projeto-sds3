package com.cursospringreact.dsvendas.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe de vendedor(Seller)
 * @author Leandro
 *
 */
@Entity
@Table(name = "tb_sellers")
public class Seller implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "seller")
	private List<Sale> listaSales = new ArrayList<>();
	
	/**
	 * construtor vazio
	 */
	public Seller() {
	}

	/**
	 * construtor com argumentos
	 * @param id
	 * @param name
	 */
	public Seller(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/*Métodos de acesso*/
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/*Em coleção de dados, se coloca apenas o get*/
	public List<Sale> getListaSales() {
		return listaSales;
	}

}
