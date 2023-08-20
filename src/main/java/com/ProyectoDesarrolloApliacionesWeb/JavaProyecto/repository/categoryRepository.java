package com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.model.Category;

public interface categoryRepository extends CrudRepository<Category, Integer> {

    List<Category> findAll();
}
