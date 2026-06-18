package com.example.ControlDeCitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ControlDeCitas.model.Cita;
import com.example.ControlDeCitas.model.Veterinario;
import com.example.ControlDeCitas.service.EspecialidadService;
import com.example.ControlDeCitas.service.VeterinarioService;

@Controller
@RequestMapping("/veterinarios")
public class VeterinarioController {

	
	@Autowired
	VeterinarioService veterinarioService;
	
	@Autowired
	EspecialidadService especialidadService;
	
	
	@GetMapping("/lista")
	public String Listar (Model model) {
		List<Veterinario> veterinarios = veterinarioService.listarTodos();
		model.addAttribute("dataVeterinarios", veterinarios);
		model.addAttribute("cantReg", veterinarios.size());
		model.addAttribute("titulo", "Lista completa de veterinarios");
		model.addAttribute("content", "veterinario/veterinarioList");
		return "layout";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("registro", new Veterinario());
		model.addAttribute("dataEspecialidad", especialidadService.listarTodas());
		model.addAttribute("titulo", "Registrar nuevo veterinario");
		model.addAttribute("content", "veterinario/veterinarioNuevo");
		return "layout";
	}
	
    @PostMapping("/registrar")
    public String guardar(@ModelAttribute("registro") Veterinario veterinario, Model model, RedirectAttributes ra) {
		System.out.println(veterinario);
        try {
        	
        	if (veterinario.getIdVet() == null) {
        		veterinarioService.registrarVeterinario(veterinario);
        	} else {
        		veterinarioService.actualizarVeterinario(veterinario);
        	}
            
            ra.addFlashAttribute("msgExito", "Veterinario guardado correctamente.");
            return "redirect:/veterinarios/lista";
        } catch (Exception e) {
            model.addAttribute("msgError", e.getMessage());
            model.addAttribute("registro", veterinario);
            model.addAttribute("titulo", veterinario.getIdVet() == null ? "Registrar Nuevo Veterionario" : "Editar Veterinario");
            model.addAttribute("content", "veterinario/veterinarioNuevo");
            return "layout"; 
        }
    }
	
	@GetMapping("/infoEdit/{id}")
	public String obtenerVeterinarioEdit (@PathVariable("id") Integer id, Model model) {
		Veterinario veterinario = veterinarioService.obtenerPorId(id).orElse(null);
		model.addAttribute("registro", veterinario);
		model.addAttribute("dataEspecialidad", especialidadService.listarTodas());
		model.addAttribute("content", "veterinario/veterinarioEdit");
		return "layout";
	}
	@PostMapping("/eliminar")
	public String eliminar(@org.springframework.web.bind.annotation.RequestParam("id") Integer id) {
		veterinarioService.eliminarVeterinario(id);
		return "redirect:/veterinarios/lista";
	}

	@PostMapping("/buscar")
	public String buscar(@org.springframework.web.bind.annotation.RequestParam("txtBuscar") String txtBuscar, Model model) {
		List<Veterinario> veterinarios = veterinarioService.buscarPorNombre(txtBuscar);
		model.addAttribute("dataVeterinarios", veterinarios);
		model.addAttribute("cantReg", veterinarios.size());
		model.addAttribute("titulo", "Lista completa de veterinarios");
		model.addAttribute("content", "veterinario/veterinarioList");
		return "layout";
	}
	
}
