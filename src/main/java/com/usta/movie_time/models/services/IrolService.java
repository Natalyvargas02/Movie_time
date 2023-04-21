package com.usta.movie_time.models.services;

import com.usta.movie_time.entities.rolEntity;

import java.util.List;

public interface IrolService {
    public List<rolEntity> findAll();

    public void save(rolEntity rol);

    public void remove(Long id);

    public rolEntity updateRol(rolEntity rol);


    //no existe changeState por el momento

    public rolEntity findOne(Long id);
}
