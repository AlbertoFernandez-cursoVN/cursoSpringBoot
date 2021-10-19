package com.cursoVN.videojuegos.controller;

import com.cursoVN.videojuegos.dominio.Distribuidor;
import com.cursoVN.videojuegos.dominio.Videojuego;
import com.cursoVN.videojuegos.services.DistribuidorService;
import com.cursoVN.videojuegos.services.VideojuegoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//controlador de operaciones CRUD(Create,Read,Update,Delete) de videojuegos
@Controller
public class VideojuegosCrudController {

    //Inyeccion de dependencias
    @Autowired
    private DistribuidorService distribuidorService;
    @Autowired
    private VideojuegoService videojuegoService;

    //metodo que insertará un videojuego o lo modificará segun venga o no informado el id del objeto que recuperamos
    @GetMapping("/videojuegos/crear")
    public String mostrarFormularioAlta(@RequestParam(required = false, name = "id") Integer id, Model model) {
        List<Distribuidor> lista = distribuidorService.getDistribuidores();
        model.addAttribute("distribuidor", lista);
        Videojuego videojuego;
        //si el id de entrada es nulo quiere decir que estamos creando un juego nuevo por lo que insertamos uno vacio en la vista
        if (id == null) {
            videojuego = new Videojuego();
        } else {
            //si no es nulo significa que debemos recuperar ese objeto de la base de datos para cargarlo en la vista y poder modificarlo
            videojuego = videojuegoService.getVideojuegoById(id);
        }
        //cargamos el objeto correspondiente en el modelo
        model.addAttribute("videojuego", videojuego);

        return "formVideojuegos";
    }

    //si yo dejo esto asi, lo que hago es un get y por lo tanto toda mi informacion viajaria en al url y lo verian todos, asi que vamos a hacer un post
    /* @RequestMapping("/videojuegos/guardar")
    public String guardarVideojuego(){
        return null;
    }*/
    //cuando realizamos un post a una url toda la informacion en vez de venir en la url, viene en el body de la pagina y no es accesible en la url
    // tambien puede ponerse asi
    // @RequestMapping(method = RequestMethod.POST, value = "/videojuegos/guardar" )
    //metodo que atiende la url que se accede cuando queremos modificar o guardar un videojuego
    @PostMapping("/videojuegos/guardar")
    public String guardarVideojuego(Videojuego videojuego) {
        videojuegoService.guardarVideojuego(videojuego);
        //si un metodo de un controller retorna redirect:/url se le envia al navegador la orden de visitar esa url
        //si yo pongo directamente listado se me queda en la url "videojuegos/guardar"
        return "redirect:/";
    }

    //Metodo que nos permite eliminar un videojuego pasandole un id
    @GetMapping("/videojuegos/eliminar")
    public String eliminarVideojuego(@RequestParam(name="id",required=true) Integer id){
        videojuegoService.eliminarVideojuego(id);
        return "redirect:/";
    }
}
