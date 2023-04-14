package com.usta.movie_time.models.dao;

import com.usta.movie_time.entities.peliculaEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface peliculaDAO extends CrudRepository<peliculaEntity,Long> {
    //nuevo
    @Transactional
    @Modifying
    @Query("UPDATE peliculaEntity SET estado = false WHERE idpelicula = ?1") //nuevo el ?1 es porque es el primer parametro
    public void changeState(Long id);

    @Transactional
    @Modifying
    @Query("SELECT uni FROM peliculaEntity uni WHERE uni.idpelicula NOT IN(SELECT pel.idpelicula FROM peliculaEntity pel)")
    public List<peliculaEntity> selectOnePel();
}


