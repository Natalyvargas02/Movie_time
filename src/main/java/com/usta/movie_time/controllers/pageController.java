package com.usta.movie_time.controllers;

import com.usta.movie_time.models.services.IpeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageController {


    @Autowired
    private IpeliculaService ipeliculaService;

    @GetMapping("/acerca")
    public String acercaade(Model model){
        model.addAttribute("titulo","Acerca de");
        return "acerca";
    }
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


}
