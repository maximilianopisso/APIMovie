package com.example.newmovieapi.controller;

import com.example.newmovieapi.model.Pelicula;
import com.example.newmovieapi.service.ServiciosPelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("desafio4/APImovies")
@RestController

public class PeliculaController {

    private final ServiciosPelicula movieService;

    @Autowired
    public PeliculaController(ServiciosPelicula servicioPelicula) {
        this.movieService = servicioPelicula;
    }
    
    
    @GetMapping("/")
    public String hello() {
    	return movieService.saludo();
    }
   

    @GetMapping("/peliculas")
    public List<Pelicula> getMovies(){
        return movieService.getMovies();
    }

    @PostMapping("/addpelicula")
    public Pelicula createMovie(@RequestBody Pelicula movie){
        return movieService.createMovie(movie);
    }

    @DeleteMapping("/deletepelicula/{id}")
    public boolean deleteMovie(@PathVariable Integer id){
        return movieService.deleteMovie(id);
    }

    @PutMapping("/updatepelicula/{id}")
    public Pelicula updateMovie(@RequestBody Pelicula movie, @PathVariable Integer id){
        return (movieService.updateMovie(movie, id))
                .orElseThrow(() -> new RuntimeException("Movie not found!"));
    }
}
