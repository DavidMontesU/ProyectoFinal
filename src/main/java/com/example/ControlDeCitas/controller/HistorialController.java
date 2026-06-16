package com.example.ControlDeCitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ControlDeCitas.model.HistorialClinico;
import com.example.ControlDeCitas.service.HistorialClinicoService;

@Controller
@RequestMapping("/historialclinico")
public class HistorialController {

	@Autowired
	HistorialClinicoService historialClinicoService;
	
	@GetMapping("/lista/{id}")
	public String Listar ( @PathVariable("id") Integer id, Model model) {
		List<HistorialClinico> historialClinico = historialClinicoService.obtenerPorMascota(id);
		model.addAttribute("dataHistorial" ,historialClinico);
		model.addAttribute("cantReg", historialClinico.size());
		model.addAttribute("titulo", "Lista completa de historial clinico");
		return "historial/historialList";
	}
}
