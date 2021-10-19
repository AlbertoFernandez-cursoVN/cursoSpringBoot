/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursoVN.videojuegos.services;

import com.cursoVN.videojuegos.dominio.Videojuego;
import com.cursoVN.videojuegos.repository.VideojuegoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alberto
 */
//implementacion del servicio de videojuegos
@Service
public class VideojuegoServiceImpl implements VideojuegoService {

    //ejemplo de injeccion por constructor
    private VideojuegoRepository videojuegoRepository;

    //inteccion por constructor, Spring se da cuenta de que esta clase necesita un repositorio para instanciarse y le inyecta uno
    public VideojuegoServiceImpl(VideojuegoRepository videojuegoRepository) {
        this.videojuegoRepository = videojuegoRepository;
    }

    //metodo que devuelve todos los videojuegos
    @Override
    public List<Videojuego> getListado() {
        /*Videojuego videojuego = new Videojuego();
        List<Videojuego> lista = new ArrayList<Videojuego>();
        videojuego.setNombre("Dark souls");
        videojuego.setDescripcion("Querrás llorar muy fuerte");
        videojuego.setUrlImagen("https://image.api.playstation.com/cdn/EP0700/CUSA03365_00/OFMeAw2KhrdaEZAjW1f3tCIXbogkLpTC.png");
        lista.add(videojuego);
        lista.add(new Videojuego("New World","Esperar cola simulator","https://cdn.cloudflare.steamstatic.com/steam/apps/1063730/header.jpg?t=1632842444"));
        lista.add(new Videojuego("Baldurs gate 3","Por favor que salga ya","https://www.muycomputer.com/wp-content/uploads/2020/02/Baldurs_Gate_3.jpg"));
        return lista;*/
        return videojuegoRepository.buscarTodos();
    }

    //metodo que devuelve los juegos filtrados por distribuidor
    @Override
    public List<Videojuego> getVideojuegoPorDistribuidor(int id) {
        return videojuegoRepository.findByDistribuidor(id);
    }
    //metodo para buscar videojuegos por nombre
    @Override
    public List<Videojuego> buscarVideojuego(String consulta) {
        return videojuegoRepository.findByNombreContainingOrderByNombreAsc(consulta);
    }
    //metodo para guardar un videojuego en la base de datos
    @Override
    public Videojuego guardarVideojuego(Videojuego videojuego) {
        return videojuegoRepository.save(videojuego);
    }
    //metodo que devuelve un videojuego por segun el id
    @Override
    public Videojuego getVideojuegoById(Integer id) {
        return videojuegoRepository.getById(id);
    }
    //metodo para eliminar un videojuego de la base de datos
    @Override
    public void eliminarVideojuego(Integer id) {
        videojuegoRepository.deleteById(id);
    }

}
