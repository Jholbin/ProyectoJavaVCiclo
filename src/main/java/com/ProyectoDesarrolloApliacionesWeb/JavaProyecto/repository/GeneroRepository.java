package com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.model.Gender;

public interface GeneroRepository extends CrudRepository<Gender, Integer>{

    List<Gender> findAll();
    
}
