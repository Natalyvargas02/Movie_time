package com.usta.movie_time.models.services;

import com.usta.movie_time.entities.peliculaEntity;
import com.usta.movie_time.models.dao.peliculaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class peliculaServiceImplement implements IpeliculaService {

    @Autowired
    private peliculaDAO peliculaDAO;


    @Override
    @Transactional(readOnly = true)
    public List<peliculaEntity> findAll() {
        return (List<peliculaEntity>) peliculaDAO.findAll();
    }


    @Override
    @Transactional
    public void save(peliculaEntity pelicula) {
        peliculaDAO.save(pelicula);

    }


    @Override
    @Transactional
    public void remove(Long id) {
        peliculaDAO.deleteById(id);
    }


    @Override
    @Transactional
    public peliculaEntity updateUniversity(peliculaEntity pelicula) {
        return peliculaDAO.save(pelicula);
    }

    //nuevo
    @Override
    @Transactional
    public void changeState(Long id) {
        peliculaDAO.changeState(id);
    }

    @Override
    @Transactional(readOnly = true)
    public peliculaEntity findOne(Long id) {
        return peliculaDAO.findById(id).orElse(null);
    }


    @Transactional(readOnly = true)
    public List<peliculaEntity> selectOnePel() {
        return (List<peliculaEntity>) peliculaDAO.selectOnePel();
    }

}
