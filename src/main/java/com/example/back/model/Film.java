package com.example.back.model;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;

@Entity
@Table(name = "film")
@EnableAutoConfiguration
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long film_id;

    @Column(name = "filmName")
    private String film_name;

    @Column(name = "filmPrix")
    private String film_prix;

    @Column(name = "filmInfo")
    private String film_info;

    @Column(name = "filmShortInfo")
    private String film_short_info;

    @Column(name = "filmType")
    private String film_type;

    @Column(name = "filmStock")
    private String film_stock;


    public Film() {

    }


    public Film(String film_name, String film_info, String film_prix, String film_short_info, String film_type, String film_stock) {
        super();
        this.film_name = film_name;
        this.film_info = film_info;
        this.film_short_info = film_short_info;
        this.film_prix = film_prix;
        this.film_type = film_type;
        this.film_stock = film_stock;
    }

    public Long getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Long film_id) {
        this.film_id = film_id;
    }

    public String getFilm_name() {
        return film_name;
    }

    public void setFilm_name(String film_name) {
        this.film_name = film_name;
    }

    public String getFilm_prix() {
        return film_prix;
    }

    public void setFilm_prix(String film_prix) {
        this.film_prix = film_prix;
    }

    public String getFilm_info() {
        return film_info;
    }

    public void setFilm_info(String film_info) {
        this.film_info = film_info;
    }

    public String getFilm_short_info() {
        return film_short_info;
    }

    public void setFilm_short_info(String film_short_info) {
        this.film_short_info = film_short_info;
    }

    public String getFilm_type() {
        return film_type;
    }

    public void setFilm_type(String film_type) {
        this.film_type = film_type;
    }

    public String getFilm_stock() {
        return film_stock;
    }

    public void setFilm_stock(String film_stock) {
        this.film_stock = film_stock;
    }
}