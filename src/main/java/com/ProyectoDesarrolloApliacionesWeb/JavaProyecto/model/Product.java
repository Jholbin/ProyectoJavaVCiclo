package com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.model;

import java.math.BigDecimal;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name_product;
	private String description;
	private BigDecimal unit_price;
	@CreationTimestamp
	private String creation_date;
	private String modification_date;
	private int stock;

	@ManyToOne
	@JoinColumn(name = "id_category")
	public Category category;
	
	
	
	
	
	public Product() {}
	
	
	public Product(Integer id, String name_product, String description, BigDecimal unit_price,
			String creation_date, String modification_date, int stock, Category category) {
		super();
		this.id = id;
		this.name_product = name_product;
		this.description = description;
		this.unit_price = unit_price;
		this.creation_date = creation_date;
		this.modification_date = modification_date;
		this.stock = stock;
		this.category = category;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName_product() {
		return name_product;
	}
	public void setName_product(String name_product) {
		this.name_product = name_product;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(BigDecimal unit_price) {
		this.unit_price = unit_price;
	}
	public String getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}
	public String getModification_date() {
		return modification_date;
	}
	public void setModification_date(String modification_date) {
		this.modification_date = modification_date;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
	
	
}