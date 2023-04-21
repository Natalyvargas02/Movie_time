package com.usta.movie_time.models.services;

import com.usta.movie_time.entities.generoEntity;
import com.usta.movie_time.entities.peliculaEntity;

import java.util.List;

public interface IgeneroService {
    public List<generoEntity> findAll();

    public void save(generoEntity genero);

    public void remove(Long id);

    public generoEntity updateGenero(generoEntity genero);


    public generoEntity findOne(Long id);
}
