package com.tiket.sniper.dao;

import com.tiket.sniper.model.Solver;
import com.tiket.sniper.service.SolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class SolverDao implements SolverService {

    private EntityManagerFactory emf;

    @Autowired
    public void setEmf (EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public List<Solver> listSolver(){
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Solver", Solver.class).getResultList();
    }

    @Override
    public Solver saveOrUpdate(Solver solver){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Solver saved = em.merge(solver);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public Solver getIdSolver(Integer id){
        EntityManager em = emf.createEntityManager();
        return em.find(Solver.class, id);
    }
}
