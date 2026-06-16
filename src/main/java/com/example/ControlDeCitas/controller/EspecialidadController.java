package com.example.ControlDeCitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ControlDeCitas.model.Especialidad;
import com.example.ControlDeCitas.service.EspecialidadService;


@Controller
@RequestMapping("/especialidad")
public class EspecialidadController {

	@Autowired
	EspecialidadService especialidadService;
	
	
	@GetMapping("/lista")
	public String Listar (Model model) {
		List<Especialidad> especialidad = especialidadService.listarTodas();
		model.addAttribute("dataEspecialidad", especialidad);
		model.addAttribute("cantReg", especialidad.size());
		model.addAttribute("titulo", "Lista completa de especialidades");
		return "especialidad/especialidadList";
	}
}
