package com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.model;

import java.math.BigDecimal;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_product;
	private String name_product;
	private String description;
	private String url_img;
	private BigDecimal unit_price;
	@CreationTimestamp
	private String creation_date;
	private String modification_date;
	private int stock;
	private Category category;
	
	
	
	
	
	public Product() {}
	
	
	public Product(Integer id_product, String name_product, String description, String url_img, BigDecimal unit_price,
			String creation_date, String modification_date, int stock, Category category) {
		super();
		this.id_product = id_product;
		this.name_product = name_product;
		this.description = description;
		this.url_img = url_img;
		this.unit_price = unit_price;
		this.creation_date = creation_date;
		this.modification_date = modification_date;
		this.stock = stock;
		this.category = category;
	}
	
	
	
	public Integer getId_product() {
		return id_product;
	}
	public void setId_product(Integer id_product) {
		this.id_product = id_product;
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
	public String getUrl_img() {
		return url_img;
	}
	public void setUrl_img(String url_img) {
		this.url_img = url_img;
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