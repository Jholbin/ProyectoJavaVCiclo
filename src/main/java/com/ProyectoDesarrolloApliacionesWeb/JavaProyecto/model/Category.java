package com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.model;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Category")
public class Category {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String description;
    @CreationTimestamp
    private String creation_date;
    private String modification_date;




    public Category() {}
	

	public Category(int id, String description, String creation_date, String modification_date) {
		super();
		this.id = id;
		this.description = description;
        this.creation_date = creation_date;
        this.modification_date = modification_date;
	}
	
    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
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

}

