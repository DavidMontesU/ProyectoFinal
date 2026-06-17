package com.example.ControlDeCitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public String guardar(@RequestParam(value="codEsp", required=false) Integer codEsp,
						  @RequestParam(value="txtCodigo", required=false) Integer txtCodigo,
						  @RequestParam(value="txtDescripcion", required=false) String descripcion,
						  @RequestParam(value="type", required=false) String type,
						  Model model, RedirectAttributes ra) {
		Especialidad especialidad = new Especialidad();
		// Some templates pass codEsp, some pass txtCodigo
		if (codEsp != null) especialidad.setIdEspecialidad(codEsp);
		else if (txtCodigo != null) especialidad.setCodEsp(String.valueOf(txtCodigo));
		especialidad.setDescripcion(descripcion);
		especialidadService.guardar(especialidad);
		return "redirect:/especialidad/lista";
	}
}
