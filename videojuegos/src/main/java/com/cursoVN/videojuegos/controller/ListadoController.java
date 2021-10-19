/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursoVN.videojuegos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import com.cursoVN.videojuegos.services.VideojuegoService;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Alberto
 */
//clase controller que gestionará las listas de juegos que se muestran en el navegador
// estas clases controller se encargan de atender las peticiones web, un mismo controller puede tener varios metodos que atiendan a distintas URLs
@Controller
public class ListadoController {

    //inyeccion de dependecias del servicio,
    //con autowired, spring busca una clase que implemente esta interfaz y la inyecta. 
    //esto hace que si alguna vez cambiamos la clase que implementa la interfaz no tendremos que tocar este código.
    @Autowired
    private VideojuegoService listadoService;

    //metodo que atiende a la direccion raiz, el html del template debe llamarse igual que el string que devuelve
    @GetMapping("/")
    public String listadoVideojuegos(Model model) {

        //agregamos el listado de juegos al modelo
        model.addAttribute("lista", listadoService.getListado());
        return "listado";

    }

    //Metodo que devuelve un listado de juegos filtrado por distribuidor
    @GetMapping("/videojuegosPorDistribuidor")
    public String listadoVideojuegosPorDistribuidor(@RequestParam(defaultValue = "1") int id, Model model) {
        //agregamos el listado de juegos al modelo
        model.addAttribute("lista", listadoService.getVideojuegoPorDistribuidor(id));
        return "listado";

    }

    //metodo que nos permite filtrar juegos buscandolos por nombre
    @GetMapping("/buscar")
    public String buscarVideojuegos(@RequestParam(name = "q", required = false) String consulta, Model model) {
        //si el parametro consulta es nulo, volvemos a la raiz
        if (consulta == null) {
            return "redirect:/";
        } else {
            model.addAttribute("lista", listadoService.buscarVideojuego(consulta));
            return "listado";
        }

    }

}
