package com.example.back.controller;


import com.example.back.exception.ResourceNotFoundException;
import com.example.back.model.Film;
import com.example.back.repository.FilmRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
public class FilmController {

    @Autowired

    private FilmRepository filmRepository;

    @CrossOrigin( origins = "*")
    @GetMapping("/film")
    public List<Film> getAllFilm(){
        return filmRepository.findAll();
    }
    @CrossOrigin( origins = "*")
    @PostMapping("/film")
    public Film createFilm(@RequestBody Film film) {
        return filmRepository.save(film);

    }
    @CrossOrigin( origins = "*")
    @GetMapping("/film/{id}")
    public  ResponseEntity<Film>  getFilmId(@PathVariable Long id){
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Le film: " + id + " n'existe pas"));
        return ResponseEntity.ok(film);
    }
    @CrossOrigin( origins = "*")
    @PutMapping("/film/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable Long id, @RequestBody Film filmDetails) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Le film: " + id + " n'existe pas"));
        film.setFilm_name(filmDetails.getFilm_name());
        film.setFilm_prix(filmDetails.getFilm_prix());
        film.setFilm_info(filmDetails.getFilm_info());
        film.setFilm_short_info(filmDetails.getFilm_short_info());
        film.setFilm_type(filmDetails.getFilm_type());
        film.setFilm_stock(filmDetails.getFilm_stock());

        Film updateFilm = filmRepository.save(film);


        return ResponseEntity.ok(updateFilm);
    }
    @CrossOrigin( origins = "*")
    @DeleteMapping("/film/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteFilm(@PathVariable Long id){
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Le film: " + id + " n'existe pas"));

        filmRepository.delete(film);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
