package com.example.ControlDeCitas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("content", "home");
        // Because home uses menu and footer directly, we don't need layout if it's already structured that way
        // But the user said "adapta el proyecto para hacer uso de los archivos html como errorLogin , footer, home , layout , login, menu, msgError"
        // So we just return "home" which will process home.html and include menu and footer.
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
