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
	public String guardar(@ModelAttribute("especialidadDataEdit") Especialidad especialidad, Model model, RedirectAttributes ra) {
		try {
			especialidadService.guardar(especialidad);
			ra.addFlashAttribute("msgExito", "Especialidad guardada correctamente.");
			return "redirect:/especialidad/lista";
		} catch (Exception e) {
			model.addAttribute("msgError", e.getMessage());
			return "redirect:/especialidad/lista";
		}
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("especialidadDataEdit", new Especialidad());
		model.addAttribute("titulo", "Registrar nueva especialidad");
		model.addAttribute("content", "especialidad/especialidadNueva");
		return "layout";
	}

	@GetMapping("/infoEdit/{id}")
	public String obtenerEspecialidadEdit (@org.springframework.web.bind.annotation.PathVariable("id") String id, Model model) {
		Especialidad especialidad = especialidadService.obtenerPorId(id).orElse(null);
		model.addAttribute("especialidadDataEdit", especialidad);
		model.addAttribute("titulo", "Editar especialidad");
		model.addAttribute("content", "especialidad/especialidadEdit");
		return "layout";
	}
	
	@PostMapping("/eliminar")
	public String eliminar(@org.springframework.web.bind.annotation.RequestParam("id") String id, RedirectAttributes ra) {
		try {
			especialidadService.eliminar(id);
			ra.addFlashAttribute("msgExito", "Especialidad eliminada correctamente.");
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			ra.addFlashAttribute("msgError", "No se puede eliminar la especialidad porque está asignada a uno o más veterinarios.");
		} catch (Exception e) {
			ra.addFlashAttribute("msgError", "Error al eliminar la especialidad: " + e.getMessage());
		}
		return "redirect:/especialidad/lista";
	}

}
