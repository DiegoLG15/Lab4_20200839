package com.example.lab4_20200839.controllers;

import com.example.lab4_20200839.entity.User;
import com.example.lab4_20200839.entity.Vuelo;
import com.example.lab4_20200839.repository.ReservaRepository;
import com.example.lab4_20200839.repository.UserRepository;
import com.example.lab4_20200839.repository.VueloRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
public class ReservaController {
    private final ReservaRepository reservaRepository;
    private final VueloRepository vueloRepository;
    private final UserRepository userRepository;

    public ReservaController(ReservaRepository reservaRepository,
                             VueloRepository vueloRepository,
                             UserRepository userRepository) {
        this.reservaRepository = reservaRepository;
        this.vueloRepository = vueloRepository;
        this.userRepository = userRepository;
    }

    @PostMapping("/newReserva")
    public String nuevaReserva(@RequestParam("id3") String correo, @RequestParam("id4") String contrasena,@RequestParam("id1") Integer idUsuario, @RequestParam("id2") Integer id2, @RequestParam("precio") BigDecimal precio, RedirectAttributes attr){
        reservaRepository.nuevaReserva(precio,idUsuario,id2);
        attr.addAttribute(correo,contrasena);
        return "redirect:/homePage"+correo+contrasena;
    }
    @GetMapping("/homePage/")
    public  String principal(Model model, RedirectAttributes attr, @PathVariable("correo") String correo, @PathVariable("contrasena") String contrasena){
        attr.addFlashAttribute("msg", "Se realizó con éxito su compra");
        Optional<User> optUser = Optional.ofNullable(userRepository.verificarCuenta(correo, contrasena));
        if (optUser.isPresent()) {
            User user=optUser.get();
            model.addAttribute("user",user);
            List<Vuelo> lista = vueloRepository.findAll();
            model.addAttribute("listVuelo", lista);
        }
        return "homePage";
    }
}
