package com.usta.movie_time.models.services;

import com.usta.movie_time.entities.peliculaEntity;

import java.util.List;

public interface IpeliculaService {
    public List<peliculaEntity> findAll();

    public void save(peliculaEntity pelicula);

    public void remove(Long id);

    public peliculaEntity updateUniversity(peliculaEntity pelicula);

    public void changeState(Long id);

    public peliculaEntity findOne(Long id);

    public List<peliculaEntity> topPelis();
}




