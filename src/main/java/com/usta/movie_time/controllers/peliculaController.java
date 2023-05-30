package com.usta.movie_time.controllers;

import com.usta.movie_time.entities.peliculaEntity;
import com.usta.movie_time.models.services.IpeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class peliculaController {

    @Autowired
    private IpeliculaService ipeliculaService;


    @GetMapping("listarpeliculas")
    public String listarpeliculas(Model model) {
        model.addAttribute("peliculas", ipeliculaService.findAll());
        model.addAttribute("titulos", "Listado Peliculas");
        return "listarpeliculas";
    }

    @GetMapping("/detallesEstrenos/{id}")
    public String listarImagenes(@PathVariable(value="id")Long id, Model model){
        model.addAttribute("titulo","Detalle");
        model.addAttribute("imagen",ipeliculaService.findOne(id));
        return "detallesEstrenos";
    }
    @GetMapping("crearpelicula")
    public String crearpelicula(Model model) {
        model.addAttribute("titulo", "Crear Pelicula");
        model.addAttribute("pelicula", new peliculaEntity());
        return "crearpelicula";
    }

    @PostMapping(value = "crearpelicula")
    public String guardarpelicula(@Valid @ModelAttribute peliculaEntity pelicula, BindingResult result, SessionStatus
            status,@RequestParam("file") MultipartFile imagen)

    {
        if (result.hasErrors()) {
            return "error500";
        }
        if(!imagen.isEmpty()){
            Path directorioImagenes = Paths.get("src//main//resources//static//images");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

            try{
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);

                pelicula.setImagen(imagen.getOriginalFilename());

            }catch (IOException e){
                e.printStackTrace();
            }
        }
        pelicula.setEstado(true);
        ipeliculaService.save(pelicula);
        status.setComplete();
        return "redirect:/listarpeliculas";
    }
    @GetMapping("/detallesImagenes/{id}")
    public String listarImagenesByiD(@PathVariable(value="id")Long id, Model model){
        model.addAttribute("titulo","Detalle");
        model.addAttribute("imagen",ipeliculaService.findOne(id));
        return "detallesImagenes";
    }

    @RequestMapping(value = "/eliminarpelicula/{id}") //nuevo
    public String eliminarById(@PathVariable(value = "id") Long id){
        if(id>0){
            ipeliculaService.remove(id);
        }else{
            return "redirect:/error500";
        }
        return "redirect:/listarpeliculas";
    }

    @RequestMapping(value = "/cambiarEstadopelicula/{id}")
    public String cambiarEstadopelicula(@PathVariable(value = "id")Long id){
        if(id>0){
            ipeliculaService.changeState(id);
        }else{
            return "redirect:/error500";
        }
        return "redirect:/listarpeliculas";
    }
    @GetMapping("/editarpelicula/{id}")
    public String mostrarFormulariopelicula(
            @PathVariable(value="id")Long id, Model model){
        model.addAttribute("titulo","Editar pelicula");
        model.addAttribute("peliculaActualizar",ipeliculaService.findOne(id));
        return "editarpelicula";
    }

    ////////////////////


    @PostMapping("/listarpeliculas/nuevo")
    public ModelAndView registrarPelicula(@Validated peliculaEntity pelicula, BindingResult bindingResult) {
        if(bindingResult.hasErrors() || pelicula.getImagen().isEmpty()) {
            if(pelicula.getImagen().isEmpty()) {
                bindingResult.rejectValue("imagen","MultipartNotEmpty");
            }

        /////   List<generoEntity> generos = igeneroService.findAll(Sort.by("sinopsis")); //////
            return new ModelAndView("pelicula/index")
                    .addObject("pelicula",pelicula);
        }
        ipeliculaService.save(pelicula);
        return new ModelAndView("redirect:/listarpeliculas");
    }

///////////////////////
    @PostMapping("editarpelicula/{id}")
    public String actualizarpelicula(
            @PathVariable(value = "id") Long id,
            @ModelAttribute("peliculaActualizar")
            peliculaEntity pelicula
    ){
        peliculaEntity peliculaExistente =
                ipeliculaService.findOne(id);
        peliculaExistente.setEstado(true);
        peliculaExistente.setTitulo(pelicula.getTitulo());
        peliculaExistente.setSinopsis(pelicula.getSinopsis());
        peliculaExistente.setFecha_estreno(pelicula.getFecha_estreno());
        peliculaExistente.setYoutube_trailer_id(pelicula.getYoutube_trailer_id());
        peliculaExistente.setImagen(pelicula.getImagen());

        ipeliculaService.updateUniversity(peliculaExistente);
        return "redirect:/listarpeliculas";
    }

    @GetMapping("/Estrenos1")
    public String topPelis1(Model model) {
        model.addAttribute("topPelis", ipeliculaService.topPelis());
        model.addAttribute("titulos", "Ultimos estrenos");
        return "/Estrenos1";
    }
}
