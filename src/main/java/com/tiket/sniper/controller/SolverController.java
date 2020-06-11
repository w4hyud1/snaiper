package com.tiket.sniper.controller;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.tiket.sniper.model.Solver;
import com.tiket.sniper.service.SolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Controller
public class SolverController {

    private SolverService solverService;

    @Autowired
    public void setSolverService(SolverService solverService){
        this.solverService = solverService;
    }

    @RequestMapping("/solver")
    public String SolverList(Model model){
        model.addAttribute("solver", solverService.listSolver());
        return "solver";
    }

    @RequestMapping(value = "/solver/edit/{id}",  method = RequestMethod.GET)
    public String editData(@PathVariable Integer id, Model model){
        model.addAttribute("solver", solverService.getIdSolver(id));
        return "formSolver";
    }

    @RequestMapping(value = "solver/upload", method = RequestMethod.GET)
    public String showUploadSolver(Model model){
        model.addAttribute("solver", new Solver());
        return "formUploadSolver";
    }

    @PostMapping("solver/upload_csv_file")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file, Model model) {

        // validate file
        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a CSV file to upload.");
            model.addAttribute("status", false);
        } else {

            // parse CSV file to create a list of `User` objects
            try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

                // create csv bean reader
                CsvToBean<Solver> csvToBean = new CsvToBeanBuilder(reader)
                        .withType(Solver.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                // convert `CsvToBean` object to list of users
                List<Solver> solvers = csvToBean.parse();

                // TODO: save users in DB?

                // save users list on model
                model.addAttribute("solver", solvers);
                // model.addAttribute("solver", SolverService.saveOrUpload(solvers));
                model.addAttribute("status", true);

            } catch (Exception ex) {
                model.addAttribute("message", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }

        return "solver";
    }
}
