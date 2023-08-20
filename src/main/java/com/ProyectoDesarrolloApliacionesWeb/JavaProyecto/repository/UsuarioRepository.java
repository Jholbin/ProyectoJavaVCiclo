package com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    
    List<Usuario> findAll();
}
