package com.example.lab4_20200839.controllers;

import com.example.lab4_20200839.entity.User;
import com.example.lab4_20200839.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class InicioController {
    final UserRepository userRepository;

    public InicioController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String inicio(){
        return "inicio";
    }
    @PostMapping(value = {"/login/inicioSesion"})
    public String iniciousuario(Model model, @RequestParam("correo") String correo, @RequestParam("contrasena") String contrasena) {

        Optional<User> optUser = Optional.ofNullable(userRepository.actualizarHabitacion(correo, contrasena));
        if (optUser.isPresent()) {
            return "redirect:/homePage";
        } else {
            return "redirect:/login";
        }
    }


}
