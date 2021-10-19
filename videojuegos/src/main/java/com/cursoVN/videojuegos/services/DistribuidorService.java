/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoVN.videojuegos.services;

import com.cursoVN.videojuegos.dominio.Distribuidor;
import java.util.List;


/**
 *
 * @author Alberto
 */
//interfaz del servicio de distribuidores
public interface DistribuidorService {
   
    //metodo que devuelve todos los distribuidores
    List<Distribuidor> getDistribuidores();
    
}
