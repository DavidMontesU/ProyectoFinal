package com.example.ControlDeCitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ControlDeCitas.model.TipoServicio;
import com.example.ControlDeCitas.service.TipoServicioService;

@Controller
@RequestMapping("/tiposServicio")
public class TipoServicioController {
	
	@Autowired
	TipoServicioService tipoServicioService;
	
	@GetMapping("/lista")
	public String Listar (Model model) {
		List<TipoServicio> dataTipoServicio = tipoServicioService.listarTiposServicios();
		model.addAttribute("dataTipoServicio", dataTipoServicio);
		model.addAttribute("cantReg", dataTipoServicio.size());
		model.addAttribute("titulo", "Lista completa de tipos de servicio");
		return "tipoServicio/tipoServicioList";
	}

}
