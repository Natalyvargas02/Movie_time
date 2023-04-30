package com.usta.movie_time.controllers;

import com.usta.movie_time.entities.peliculaEntity;
import com.usta.movie_time.models.services.IpeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class pageController {


    @Autowired
    private IpeliculaService ipeliculaService;



    @GetMapping("/pensum")
    public String pensum(Model model){
        model.addAttribute("titulo","Pensum");
        return "pensum";
    }
    @GetMapping("AdiosMundo")
    public String AdiosMundo(Model model){
        model.addAttribute("titulo","Adios Mundo");
        return "AdiosMundo";
    }

    @GetMapping("peliculas")
    public String peliculas(Model model){
        model.addAttribute("peliculas", ipeliculaService.findAll());
        model.addAttribute("titulo","index");
        return "peliculas";
    }

    @GetMapping("Estrenos1")
    public String Estrenos1(Model model){
        model.addAttribute("peliculas", ipeliculaService.findAll());
        model.addAttribute("titulo","index");
        return "Estrenos1";
    }





}
