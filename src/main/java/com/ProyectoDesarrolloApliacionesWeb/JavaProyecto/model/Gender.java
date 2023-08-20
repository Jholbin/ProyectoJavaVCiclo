package com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gender")
public class Gender {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idgender;
    private String gender;

    public Gender() {

    }


    public Gender(int idgender, String gender) {
        this.idgender = idgender;
        this.gender = gender;
    }


 


    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }


    public int getIdgender() {
        return idgender;
    }


    public void setIdgender(int idgender) {
        this.idgender = idgender;
    }

    
    
}
