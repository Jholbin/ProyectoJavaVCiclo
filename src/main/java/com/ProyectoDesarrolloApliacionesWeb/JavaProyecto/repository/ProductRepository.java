package com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.model.Product;



public interface ProductRepository extends CrudRepository<Product, Integer>{
	List<Product> findAll();

	List<Product> findByDescriptionContaining(String nombre);

	List<Product> findByCategoryDescriptionContaining(String category);

}
