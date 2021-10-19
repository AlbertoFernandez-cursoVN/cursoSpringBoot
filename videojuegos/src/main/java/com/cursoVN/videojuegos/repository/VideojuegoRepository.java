/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoVN.videojuegos.repository;

import com.cursoVN.videojuegos.dominio.Videojuego;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Alberto
 */
//repositorio de videojuegos debe extender JpaRepository<Entidad,claveprimariaEntidad>
public interface VideojuegoRepository extends JpaRepository<Videojuego, Integer>{
    
    //query que devuelve todos los videojuegos ordenados por nombre
    @Query("select v from Videojuego v order by v.nombre")
    List<Videojuego> buscarTodos();
    
    //query que devuelve los videojuegos de un distribuidor
    @Query("select v from Videojuego v where v.distribuidor.id=?1 order by v.nombre")
    List<Videojuego> findByDistribuidor(int idDistribuidor);
    
    //@Query("select v from Videojuego v where v.nombre like %?1%" )
    //ejemplo de definicion de consulta en el nombre del metodo  
    List<Videojuego> findByNombreContainingOrderByNombreAsc(String consulta);
        
}
