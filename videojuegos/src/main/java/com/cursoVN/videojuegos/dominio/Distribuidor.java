/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoVN.videojuegos.dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Alberto
 */
//entidad para mapear la tabla distribuidor de la base de datos y poder tratarla como objetos
@Entity
@Table(name = "distribuidor")
public class Distribuidor implements Serializable {
    
    @Id
    //esto indica que la generacion de la clave primaria se realizará en la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //campo clave primaria
    private Integer id;
    //los campos deben llamarse igual que las tablas de la base de datos o especificar el nombre con @column
    private String nombre;
    private String sitioWeb;

    public Distribuidor() {
    }
        
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    @Override
    public String toString() {
        return "Distribuidor{" + "id=" + id + ", nombre=" + nombre + ", sitioWeb=" + sitioWeb + '}';
    }
    
    
}
