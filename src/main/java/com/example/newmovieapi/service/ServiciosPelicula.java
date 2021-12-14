package com.example.newmovieapi.service;

import com.example.newmovieapi.model.Pelicula;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosPelicula {

    private List<Pelicula> movies;

    public ServiciosPelicula(List<Pelicula> movies){
        this.movies = movies;
    }

    public List<Pelicula> getMovies() {
        return movies;
    }

    public Pelicula createMovie(Pelicula movie) {
        movies.add(movie);
        return movie;
    }

    public boolean deleteMovie(Integer id) {
        for (Pelicula m: movies){
            if(m.getId().equals(id)){
                movies.remove(m);
                return true;
            }
        } return false;
    }

    public Optional<Pelicula> updateMovie(Pelicula movie, Integer id) {
        for (Pelicula m: movies){
            if(m.getId().equals(id)){
                movies.remove(m);
                movies.add(movie);
                return Optional.ofNullable(movie);
            }
        } return null;
    }

	public String saludo() {
		return "<h1>Bienvenido a mi API de Peliculas<h1>"
		+ "<br>"+"<h2> Para obtener peliculas <h2>"
		+ "<h4>Metodo GET  url: http://localhost:8080/desafio4/APImovies/pelis<h4>"
		+"<h2> Para Agregar peliculas <h2>"
		+ "<h4>Metodo POST  url: http://localhost:8080/desafio4/APImovies/addpelicula<h4>"
		+"<h2> Para Borrar peliculas <h2>"
		+ "<h4>Metodo DELETE  url: http://localhost:8080/desafio4/APImovies/deletepelicula/{id}<h4>"
		+"<h2> Para Actualizar peliculas<h2>"
		+ "<h4>Metodo PUT url: http://localhost:8080/desafio4/APImovies/updatepelicula/{id}<h4>"; 		
}
}
