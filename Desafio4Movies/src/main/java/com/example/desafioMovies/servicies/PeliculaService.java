package com.example.desafioMovies.servicies;

import org.springframework.stereotype.Service;

import com.example.desafioMovies.models.Pelicula;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    private List<Pelicula> Peliculas;

    public PeliculaService(List<Pelicula> Peliculas){
        this.Peliculas = Peliculas;
    }

    public List<Pelicula> getPeliculas() {
        return Peliculas;
    }

    public Pelicula createPelicula(Pelicula Pelicula) {
        Peliculas.add(Pelicula);
        return Pelicula;
    }

    public boolean deletePelicula(Integer id) {
        for (Pelicula m: Peliculas){
            if(m.getId().equals(id)){
                Peliculas.remove(m);
                return true;
            }
        } return false;
    }

    public Optional<Pelicula> updatePelicula(Pelicula pelicula, Integer id) {
        for (Pelicula m: Peliculas){
            if(m.getId().equals(id)){
                Peliculas.remove(m);
                Peliculas.add(pelicula);
                return Optional.ofNullable(pelicula);
            }
        } return null;
    }
}
