package com.usta.movie_time.models.services;

import com.usta.movie_time.entities.generoEntity;
import com.usta.movie_time.entities.peliculaEntity;
import com.usta.movie_time.models.dao.generoDAO;
import com.usta.movie_time.models.dao.peliculaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class generoServiceImplement implements IgeneroService {


    @Autowired
    private generoDAO generoDAO;

    @Override
    @Transactional(readOnly = true)
    public List<generoEntity> findAll() {
        return (List<generoEntity>) generoDAO.findAll();
    }

    @Override
    @Transactional
    public void save(generoEntity genero) {
        generoDAO.save(genero);

    }
    @Override
    @Transactional
    public void remove(Long id) {
        generoDAO.deleteById(id);
    }

    @Override
    @Transactional
    public generoEntity updateGenero(generoEntity genero) {
        return generoDAO.save(genero);
    }


    @Override
    @Transactional(readOnly = true)
    public generoEntity findOne(Long id) {
        return generoDAO.findById(id).orElse(null);
    }


}
