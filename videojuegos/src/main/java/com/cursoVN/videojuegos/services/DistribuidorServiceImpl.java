/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoVN.videojuegos.services;

import com.cursoVN.videojuegos.dominio.Distribuidor;
import com.cursoVN.videojuegos.repository.DistribuidorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alberto
 */
//esta anotacion indica a spring que es un componente que puede gestionar
@Service
public class DistribuidorServiceImpl implements DistribuidorService {

    //inyeccion de dependecias
    @Autowired
    private DistribuidorRepository distribuidorRepository;
    //consulta de distribuidores al repositorio
    @Override
    public List<Distribuidor> getDistribuidores() {
        
        return distribuidorRepository.getDistribuidores();
        
    }
    
}
