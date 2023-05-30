/*package com.usta.movie_time.entities;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "generos")
public class genero_peliculaEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //lave primaria se genera sola
    @Column(name = "idgenero")
    private Long idgenero;

    @JoinColumn(name = "idgenero", referencedColumnName = "idgenero")
    @ManyToOne(fetch = FetchType.LAZY)
    private generoEntity idgenero;

    @JoinColumn(name = "idpelicula", referencedColumnName = "idpelicula")
    @ManyToOne(fetch = FetchType.LAZY)
    private peliculaEntity idpelicula;




}
*/