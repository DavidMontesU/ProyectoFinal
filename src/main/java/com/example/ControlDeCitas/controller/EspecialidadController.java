package com.example.ControlDeCitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ControlDeCitas.model.Especialidad;
import com.example.ControlDeCitas.service.EspecialidadService;

@Controller
@RequestMapping("/especialidad")
public class EspecialidadController {

	@Autowired
	EspecialidadService especialidadService;
	
	@GetMapping("/lista")
	public String listar (Model model) {
		List<Especialidad> especialidad = especialidadService.listarTodas();
		model.addAttribute("dataEspecialidad", especialidad);
		model.addAttribute("cantReg", especialidad.size());
		model.addAttribute("titulo", "Lista completa de especialidades");
		model.addAttribute("content", "especialidad/especialidadList");
		return "layout";
	}

	@PostMapping("/registrar")
	public String guardar(@ModelAttribute("especialidad") Especialidad especialidad, Model model, RedirectAttributes ra) {
		try {
			especialidadService.guardar(especialidad);
			ra.addFlashAttribute("msgExito", "Especialidad guardada correctamente.");
			return "redirect:/especialidad/lista";
		} catch (Exception e) {
			model.addAttribute("msgError", e.getMessage());
			return "redirect:/especialidad/lista";
		}
	}
}
