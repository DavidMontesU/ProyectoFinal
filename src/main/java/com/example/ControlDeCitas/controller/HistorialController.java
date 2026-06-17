package com.example.ControlDeCitas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ControlDeCitas.model.HistorialClinico;
import com.example.ControlDeCitas.service.HistorialClinicoService;

@Controller
@RequestMapping("/historial")
public class HistorialController {

	@Autowired
	HistorialClinicoService historialClinicoService;
	
	@GetMapping("/lista/{id}")
	public String listar( @PathVariable("id") Integer id, Model model) {
		List<HistorialClinico> historialClinico = historialClinicoService.obtenerPorMascota(id);
		model.addAttribute("dataHistorial" ,historialClinico);
		model.addAttribute("cantReg", historialClinico.size());
		model.addAttribute("idMascota", id);
		model.addAttribute("titulo", "Lista completa de historial clinico");
		model.addAttribute("content", "historial/historialList");
		return "layout";
	}

	@GetMapping("/nuevo")
	public String nuevo(@RequestParam("idCita") Integer idCita, Model model) {
		HistorialClinico historial = new HistorialClinico();
		historial.setIdCita(idCita);
		model.addAttribute("historialDataEdit", historial);
		model.addAttribute("titulo", "Registrar Historial Clínico");
		model.addAttribute("content", "historial/historialNuevo");
		return "layout";
	}

	@PostMapping("/registrar")
	public String registrar(@ModelAttribute("historialDataEdit") HistorialClinico historial, 
							Model model, RedirectAttributes ra) {
		try {
			historialClinicoService.registrarHistorial(historial);
			ra.addFlashAttribute("msgExito", "Historial guardado correctamente.");
			return "redirect:/citas/lista";
		} catch (Exception e) {
			model.addAttribute("msgError", e.getMessage());
			model.addAttribute("historialDataEdit", historial);
			model.addAttribute("idCita", historial.getIdCita());
			model.addAttribute("content", "historial/historialNuevo");
			return "layout";
		}
	}

	@GetMapping("/detalle/{id}")
	public String detalle(@PathVariable("id") Integer id, Model model) {
		Optional<HistorialClinico> historial = historialClinicoService.obtenerPorId(id);
		if(historial.isPresent()) {
			model.addAttribute("historialData", historial.get());
		}
		model.addAttribute("titulo", "Detalle de Historial");
		model.addAttribute("content", "historial/historialDetalle");
		return "layout";
	}

	@GetMapping("/buscar")
	public String buscar(Model model) {
		model.addAttribute("content", "historial/historiaBuscar");
		return "layout";
	}

	@PostMapping("/buscarHistorial")
	public String buscarHistorial(@RequestParam("idMascota") Integer idMascota) {
		return "redirect:/historial/lista/" + idMascota;
	}
}
