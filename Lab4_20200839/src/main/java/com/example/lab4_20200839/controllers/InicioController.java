package com.example.lab4_20200839.controllers;

import com.example.lab4_20200839.entity.User;
import com.example.lab4_20200839.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class InicioController {
    final UserRepository userRepository;

    public InicioController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("hola")
    public String inicio(){
        return "inicio";
    }
    @GetMapping(value = {"inicio","/"})
    public String iniciousuario(Model model, @RequestParam("correo") String correo, @RequestParam("contrasena") String contrasena) {

        List<User> optUser = userRepository.actualizarHabitacion(correo,contrasena);
        return "homePage";
    }


}
