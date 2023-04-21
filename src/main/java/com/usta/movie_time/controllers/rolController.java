package com.usta.movie_time.controllers;

import com.usta.movie_time.entities.rolEntity;
import com.usta.movie_time.models.services.IrolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class rolController {

    @Autowired
    private IrolService irolService;
    @GetMapping("/ListarRoles")
    public String ListarRoles(Model model) {
        model.addAttribute("Roles", irolService.findAll());
        model.addAttribute("titulos", "Listado Roles");
        return "ListarRoles";
    }

    @GetMapping("/crearRol")
    public String crearRol(Model model) {
        model.addAttribute("titulo", "Crear Roles");
        model.addAttribute("rol", new rolEntity());
        return "crearRol";
    }

    @PostMapping(value = "/crearRol")
    public String guardarRol(@Valid rolEntity rol, BindingResult result, SessionStatus status) {
        if (result.hasErrors()) {
            return "error";
        }

        irolService.save(rol);
        status.setComplete();
        return "ListarRoles";
    }

    @RequestMapping(value = "/eliminarRol/{id}")
    public String eliminarById(@PathVariable(value = "id") Long id) {
        if (id > 0) {
            irolService.remove(id);
        } else {
            return "redirect:/error500";
        }
        return "ListarRoles";
    }

    @GetMapping("/editarRol/{id}")
    public String mostrarFormularioRol(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("titulo", "Editar Rol");
        model.addAttribute("rolActualizar", irolService.findOne(id));
        return "editarRol";
    }

    @PostMapping("editarRol/{id}")
    public String actualizarRol(@PathVariable(value = "id") Long id, @ModelAttribute("rolActualizar") rolEntity rolActualizar) {
        rolEntity rolExistente = irolService.findOne(id);
        rolExistente.setNombre_rol(rolActualizar.getNombre_rol());
        irolService.updateRol(rolExistente);
        return "ListarRoles";
    }
}

