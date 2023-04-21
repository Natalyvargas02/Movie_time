package com.usta.movie_time.models.services;

import com.usta.movie_time.entities.rolEntity;
import com.usta.movie_time.models.dao.rolDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolServiceImplement implements IrolService {

    @Autowired
    private rolDao rolDao;
    @Override
    @Transactional(readOnly = true)
    public List<rolEntity> findAll(){
        return (List<rolEntity>) rolDao.findAll();
    }

    @Override
    @Transactional
    public void save(rolEntity rol){
        rolDao.save(rol);
    }
    @Override
    @Transactional
    public void remove(Long id){
        rolDao.deleteById(id);
    }
    @Override
    @Transactional
    public rolEntity updateRol(rolEntity rol){
        return rolDao.save(rol);
    }
    //no existe changeState por el momento
    @Override
    @Transactional(readOnly = true)
    public rolEntity findOne(Long id){
        return rolDao.findById(id).orElse(null);
    }
}


