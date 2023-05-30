package com.usta.movie_time.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "generos_peliculas")
public class generoEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //lave primaria se genera sola
    @Column(name = "idgenero_pelicula")
    private Long idgenero_pelicula;

    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "titulo")
    private String titulo;



}
