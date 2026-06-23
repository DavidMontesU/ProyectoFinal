package com.example.ControlDeCitas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("content", "home");

        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/errorLogin")
    public String errorLogin() {
        return "errorLogin";
    }

    @GetMapping("/msgError")
    public String msgError() {
        return "msgError";
    }
}
