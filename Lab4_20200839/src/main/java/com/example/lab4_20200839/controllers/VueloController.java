package com.example.lab4_20200839.controllers;

import com.example.lab4_20200839.entity.Vuelo;
import com.example.lab4_20200839.repository.VueloRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class VueloController {
    private final VueloRepository vueloRepository;

    public VueloController(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

}
