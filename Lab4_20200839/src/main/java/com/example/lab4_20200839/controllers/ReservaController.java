package com.example.lab4_20200839.controllers;

import com.example.lab4_20200839.entity.Reserva;
import com.example.lab4_20200839.repository.ReservaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservaController {
    private final ReservaRepository reservaRepository;

    public ReservaController(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @GetMapping("/new")
    public String nuevaReserva(){
        return "homePage";
    }
    @PostMapping("/save")
    public String guardarReserva(Reserva reserva) {
        reservaRepository.save(reserva);
        return "redirect:/homePage";
    }

}
