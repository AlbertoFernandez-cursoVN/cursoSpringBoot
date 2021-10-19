/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoVN.videojuegos.repository;

import com.cursoVN.videojuegos.dominio.Distribuidor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Alberto
 */
//repositorio de distribuidores
public interface DistribuidorRepository extends JpaRepository<Distribuidor, Integer>{
    //query que devuelve todos los distribuidores ordenados por nombre
    @Query("select d from Distribuidor d order by d.nombre")
    public List<Distribuidor> getDistribuidores();
}
