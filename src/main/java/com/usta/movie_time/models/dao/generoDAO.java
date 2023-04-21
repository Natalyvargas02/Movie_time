package com.usta.movie_time.models.dao;

import com.usta.movie_time.entities.generoEntity;
import com.usta.movie_time.entities.peliculaEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface generoDAO extends CrudRepository<generoEntity,Long>{

}

