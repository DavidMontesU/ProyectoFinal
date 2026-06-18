package com.example.ControlDeCitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ControlDeCitas.model.TipoServicio;
import com.example.ControlDeCitas.service.TipoServicioService;

@Controller
@RequestMapping("/tiposServicio")
public class TipoServicioController {
	
	@Autowired
	TipoServicioService tipoServicioService;
	
	@GetMapping("/lista")
	public String listar (Model model) {
		List<TipoServicio> dataTipoServicio = tipoServicioService.listarTiposServicios();
		model.addAttribute("dataTipoServicio", dataTipoServicio);
		model.addAttribute("cantReg", dataTipoServicio.size());
		model.addAttribute("titulo", "Lista completa de tipos de servicio");
		model.addAttribute("content", "tipoServicio/tipoServicioList");
		return "layout";
	}

	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("tipoServicioDataEdit", new TipoServicio());
		model.addAttribute("titulo", "Registrar Nuevo Tipo de Servicio");
		model.addAttribute("content", "tipoServicio/tipoServicioNuevo");
		return "layout";
	}

	@PostMapping("/registrar")
	public String guardar(@ModelAttribute("tipoServicioDataEdit") TipoServicio tipoServicio, Model model, org.springframework.web.servlet.mvc.support.RedirectAttributes ra) {
		try {
			if (tipoServicio.getIdTipoServicio() != null && tipoServicio.getIdTipoServicio() > 0) {
				tipoServicioService.actualizarTipoServicio(tipoServicio.getDescripcion(), tipoServicio.getPrecio(), tipoServicio.getIdTipoServicio());
			} else {
				tipoServicioService.registrarTipoServicio(tipoServicio.getDescripcion(), tipoServicio.getPrecio());
			}
			ra.addFlashAttribute("msgExito", "Tipo de Servicio guardado correctamente.");
			return "redirect:/tiposServicio/lista";
		} catch (Exception e) {
			model.addAttribute("msgError", e.getMessage());
			model.addAttribute("tipoServicioDataEdit", tipoServicio);
			model.addAttribute("content", (tipoServicio.getIdTipoServicio() != null && tipoServicio.getIdTipoServicio() > 0) ? "tipoServicio/tipoServicioEdit" : "tipoServicio/tipoServicioNuevo");
			return "layout";
		}
	}

}
