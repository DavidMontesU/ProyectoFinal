package com.example.ControlDeCitas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

import com.example.ControlDeCitas.model.Usuario;
import com.example.ControlDeCitas.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/login")
	public String login(@RequestParam("txtUsername") String username, 
						@RequestParam("txtClave") String clave, 
						HttpSession session) {
		List<Usuario> validUsers = usuarioService.validarUsuario(username, clave);
		if (validUsers != null && !validUsers.isEmpty()) {
			session.setAttribute("usuario", validUsers.get(0));
			return "redirect:/home";
		}
		return "redirect:/errorLogin";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

	@GetMapping("/lista")
	public String listar(Model model) {
		List<Usuario> usuarios = usuarioService.obtenerTodosLosUsuarios();
		model.addAttribute("dataUsuario", usuarios);
		model.addAttribute("cantReg", usuarios.size());
		model.addAttribute("titulo", "Lista completa de usuarios");
		model.addAttribute("content", "usuario/usuarioList");
		return "layout";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("usuarioDataEdit", new Usuario());
		model.addAttribute("titulo", "Registrar Usuario");
		model.addAttribute("content", "usuario/usuarioNuevo");
		return "layout";
	}

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute("usuarioDataEdit") Usuario usuario, Model model, RedirectAttributes ra) {
        
        try {
            if (usuario.getIdUsuario() != null && usuario.getIdUsuario() > 0) {
                // If editing, usually password is left alone or we should handle it properly
                // But following original logic:
                if (usuario.getClave() == null || usuario.getClave().isEmpty()) {
                	Optional<Usuario> usuarioDb = usuarioService.obtenerUsuarioPorId(usuario.getIdUsuario().intValue());
                	if(usuarioDb.isPresent()) {
                		usuario.setClave(usuarioDb.get().getClave());
                	}
                }
                usuarioService.actualizarUsuario(usuario.getUsername(), usuario.getClave(), usuario.getIdTipo(), usuario.getIdUsuario().intValue());
            } else {
                usuarioService.registrarUsuario(usuario.getUsername(), usuario.getClave(), usuario.getIdTipo());
            }
            ra.addFlashAttribute("msgExito", "Usuario guardado correctamente.");
            return "redirect:/usuario/lista";
        } catch (Exception e) {
            model.addAttribute("msgError", e.getMessage());
            model.addAttribute("usuarioDataEdit", usuario);
            model.addAttribute("content", (usuario.getIdUsuario() != null && usuario.getIdUsuario() > 0) ? "usuario/usuarioEdit" : "usuario/usuarioNuevo");
            return "layout";
        }
    }

	@GetMapping("/infoEdit/{id}")
	public String obtenerEdit(@PathVariable("id") Integer id, Model model) {
		Optional<Usuario> usuario = usuarioService.obtenerUsuarioPorId(id);
		if(usuario.isPresent()) {
			model.addAttribute("usuarioDataEdit", usuario.get());
		}
		model.addAttribute("titulo", "Editar Usuario");
		model.addAttribute("content", "usuario/usuarioEdit");
		return "layout";
	}

	@PostMapping("/eliminar")
	public String eliminar(@RequestParam("id") Integer id) {
		usuarioService.eliminarUsuario(id);
		return "redirect:/usuario/lista";
	}
}
