package com.example.lab4_20200839.controllers;

import com.example.lab4_20200839.entity.User;
import com.example.lab4_20200839.entity.Vuelo;
import com.example.lab4_20200839.repository.UserRepository;
import com.example.lab4_20200839.repository.VueloRepository;
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
    final VueloRepository vueloRepository;

    public InicioController(UserRepository userRepository, VueloRepository vueloRepository) {
        this.userRepository = userRepository;
        this.vueloRepository = vueloRepository;
    }

    @GetMapping("/")
    public String inicio(){
        return "inicio";
    }
    @PostMapping(value = {"/login/inicioSesion"})
    public String iniciousuario(Model model, @RequestParam("correo") String correo, @RequestParam("contrasena") String contrasena) {

        Optional<User> optUser = Optional.ofNullable(userRepository.verificarCuenta(correo, contrasena));
        if (optUser.isPresent()) {
            User user=optUser.get();
            model.addAttribute("user",user);
            List<Vuelo> lista = vueloRepository.findAll();
            model.addAttribute("listVuelo", lista);
            return "homePage";
        } else {
            return "redirect:/";
        }
    }


}
