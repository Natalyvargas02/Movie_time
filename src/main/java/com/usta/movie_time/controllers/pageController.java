package com.usta.movie_time.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageController {
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
        model.addAttribute("titulo","index");
        return "peliculas";
    }


}
