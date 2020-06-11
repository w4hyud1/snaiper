package com.tiket.sniper.service;

import com.tiket.sniper.model.Solver;
import java.util.List;

public interface SolverService {
    List<Solver>  listSolver();
    Solver saveOrUpdate(Solver solver);
    Solver getIdSolver(Integer id);
}
