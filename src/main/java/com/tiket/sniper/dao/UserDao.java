package com.tiket.sniper.dao;

import com.tiket.sniper.model.User;
import com.tiket.sniper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class UserDao implements UserService {

    private EntityManagerFactory emf;

    @Autowired
    public void setEmf (EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public List<User> listUser(){
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from User", User.class).getResultList();
    }

}
