/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursoVN.videojuegos.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Alberto
 */
//entidad para mapear la tabla videojuego de la base de datos y poder tratarla como objetos
@Entity
@Table(name = "videojuego")
public class Videojuego implements Serializable {

    @Id
    //esto indica que la generacion de la clave primaria se realizará en la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //campo clave primaria
    private Integer id;
    private String nombre;
    private String descripcion;
    //los campos deben llamarse igual que las tablas de la base de datos o especificar el nombre con @column
    @Column(name = "imagen_url")
    private String urlImagen;
    //indica la relacion de muchos a uno entre el objeto videojuego y el objeto distribuidor
    @ManyToOne
    //hace refenrencia a la columna que contiene la clave foranea que hace referencia a la clave primaria de distribuidor
    @JoinColumn(name = "distribuidor")
    private Distribuidor distribuidor;

    public Distribuidor getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(Distribuidor distribuidor) {
        this.distribuidor = distribuidor;
    }

    public Videojuego(String nombre, String descripcion, String urlImagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
    }

    public Videojuego() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Videojuego{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", urlImagen=" + urlImagen + ", distribuidor=" + distribuidor + '}';
    }

}
