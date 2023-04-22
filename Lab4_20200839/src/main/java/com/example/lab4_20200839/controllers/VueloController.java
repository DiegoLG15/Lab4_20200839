package com.example.lab4_20200839.controllers;

import com.example.lab4_20200839.entity.Vuelo;
import com.example.lab4_20200839.repository.VueloRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VueloController {
    private final VueloRepository vueloRepository;

    public VueloController(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    @GetMapping(value = {"/homePage"})
    public String listarVuelos(Model model) {
        List<Vuelo> lista = vueloRepository.findAll();
        model.addAttribute("listVuelo", lista);

        return "homePage";
    }
}
