package com.example.ControlDeCitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ControlDeCitas.model.Usuario;
import com.example.ControlDeCitas.service.UsuarioService;

@Controller
@RequestMapping("/usuario")

public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/lista")
	public String Listar (Model model) {
		List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
		model.addAttribute("dataUsuario", usuarios);
		model.addAttribute("cantReg", usuarios.size());
		model.addAttribute("titulo", "Lista completa de usuarios");
		return "usuario/usuarioList";
	}
	
	
}
