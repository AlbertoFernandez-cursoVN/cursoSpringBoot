/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cursoVN.videojuegos.services;

import com.cursoVN.videojuegos.dominio.Videojuego;
import java.util.List;

/**
 *
 * @author Alberto
 */
//interfaz del servicio de videojuegos
public interface VideojuegoService {
    //metodo que devuelve todos los videojuegos
    public List<Videojuego> getListado();
    //metodo que devuelve los juegos filtrados por distribuidor
    public List<Videojuego> getVideojuegoPorDistribuidor(int id);
    //metodo para buscar videojuegos por nombre
    public List<Videojuego> buscarVideojuego(String consulta);
    //metodo para guardar un videojuego en la base de datos
    public Videojuego guardarVideojuego(Videojuego videojuego);
    //metodo que devuelve un videojuego por segun el id
    public Videojuego getVideojuegoById(Integer id);
    //metodo para eliminar un videojuego de la base de datos
    public void eliminarVideojuego(Integer id);
    
}
