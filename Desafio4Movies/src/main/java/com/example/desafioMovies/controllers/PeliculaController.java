package com.example.desafioMovies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.desafioMovies.models.Pelicula;
import com.example.desafioMovies.servicies.PeliculaService;
import java.util.List;

@RequestMapping("desafio4/peliculas")
@RestController

public class PeliculaController {

    private final PeliculaService servicioPeliculas;

    @Autowired
    public PeliculaController(PeliculaService peliculaService) {
        this.servicioPeliculas = peliculaService;
    }
    
    @GetMapping("/")
    public String hello() {
    	return "<h1>Bienvenido a mi API peliS<h1>"
    			+ "<br>"+"<h2> Para obtener peliculas <h2>"
    					+ "<h4>Metodo GET  url: http://localhost:8080/apipeli/v1/pelis<h4>"
    					+"<h2> Para Agregar peliculas <h2>"
    					+ "<h4>Metodo POST  url: http://localhost:8080/apipeli/v1/addpeli<h4>"
    					+"<h2> Para Borrar peliculas <h2>"
    					+ "<h4>Metodo DELETE  url: http://localhost:8080/apipeli/v1/deletepeli/{id}<h4>"
    					+"<h2> Para Actualizar peliculas<h2>"
    					+ "<h4>Metodo PUT url: http://localhost:8080/apipeli/v1/updatepeli/{id}<h4>"; 		
    }
    
    @GetMapping("/pelis")
    public List<Pelicula> getpelis(){
        return servicioPeliculas.getPeliculas();
    }

    @PostMapping("/addpeli")
    public Pelicula createpeli(@RequestBody Pelicula peli){
        return servicioPeliculas.createPelicula(peli);
    }

    @DeleteMapping("/deletepeli/{id}")
    public boolean deletepeli(@PathVariable Integer id){
        return servicioPeliculas.deletePelicula(id);
    }

    @PutMapping("/updatepeli/{id}")
    public Pelicula updatepeli(@RequestBody Pelicula peli, @PathVariable Integer id){
        return (servicioPeliculas.updatePelicula(peli, id))
                .orElseThrow(() -> new RuntimeException("Su Pelicula no fue encontrada !"));
    }
}
