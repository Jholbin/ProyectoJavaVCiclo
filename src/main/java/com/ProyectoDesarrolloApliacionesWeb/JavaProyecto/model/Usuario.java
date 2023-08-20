package com.ProyectoDesarrolloApliacionesWeb.JavaProyecto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nameuser;
    private String lastnameuser;
    private String document;
    private String address;
    private String email;
    private String passworduser;

    @ManyToOne
	@JoinColumn(name = "idgender")
	public Gender gender;

    public Usuario(){

    }

    public Usuario(int id, String nameuser, String lastnameuser, String document, String address, String email,
            String passworduser, Gender gender) {
        this.id = id;
        this.nameuser = nameuser;
        this.lastnameuser = lastnameuser;
        this.document = document;
        this.address = address;
        this.email = email;
        this.passworduser = passworduser;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameuser() {
        return nameuser;
    }

    public void setNameuser(String nameuser) {
        this.nameuser = nameuser;
    }

    public String getLastnameuser() {
        return lastnameuser;
    }

    public void setLastnameuser(String lastnameuser) {
        this.lastnameuser = lastnameuser;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassworduser() {
        return passworduser;
    }

    public void setPassworduser(String passworduser) {
        this.passworduser = passworduser;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    

    




}
