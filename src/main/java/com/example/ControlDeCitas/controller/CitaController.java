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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ControlDeCitas.model.Cita;
import com.example.ControlDeCitas.service.CitaService;
import com.example.ControlDeCitas.service.ClienteService;
import com.example.ControlDeCitas.service.MascotaService;
import com.example.ControlDeCitas.service.TipoServicioService;
import com.example.ControlDeCitas.service.VeterinarioService;

@Controller
@RequestMapping("/citas")
public class CitaController {
	
	@Autowired
	CitaService citaService;
	
	@Autowired
	MascotaService mascotaService;
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	TipoServicioService tipoServicioService;
	
	@Autowired
	VeterinarioService veterinarioService;
	
	@GetMapping("/lista")
	public String Listar (Model model) {
		List<Cita> citas = citaService.listarTodos();
		model.addAttribute("dataCitas", citas);
		model.addAttribute("cantReg", citas.size());
		model.addAttribute("titulo", "Lista completa de citas programadas");
		return "cita/cita-lista";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("registro", new Cita());
		model.addAttribute("dataMascota", mascotaService.listarTodos());
		model.addAttribute("dataTipoServicio", tipoServicioService.listarTiposServicios());
		model.addAttribute("dataVeterinario", veterinarioService.listarTodos());
		model.addAttribute("titulo", "Registrar nueva cita");
		return "cita/cita-editar";
	}

	@PostMapping("/registrar")
    public String guardar(@ModelAttribute("registro") Cita cita, Model model, RedirectAttributes ra) {
		System.out.println(cita);
        try {
        	if (cita.getIdCita() == null) {
        		citaService.registrarCita(cita);
        	} else {
        		citaService.actualizarCita(cita);
        	}
            
            ra.addFlashAttribute("msgExito", "Cita guardada correctamente.");
            return "redirect:/citas/lista";
        } catch (Exception e) {
            
            model.addAttribute("msgError", e.getMessage());
            model.addAttribute("registro", cita);
            model.addAttribute("titulo", cita.getIdCita() == null ? "Registrar Nueva Cita" : "Editar Cita");
            return "cita/cita-editar"; 
        }
    }

	@GetMapping("/infoEdit/{id}")
	public String obtenerCitaEdit (@PathVariable("id") Integer id, Model model) {
		Cita cita = citaService.obtenerCita(id);
		model.addAttribute("registro", cita);
		model.addAttribute("dataMascota", mascotaService.listarTodos());
		model.addAttribute("dataTipoServicio", tipoServicioService.listarTiposServicios());
		model.addAttribute("dataVeterinario", veterinarioService.listarTodos());
		return "cita/cita-editar";
	}
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminarCita (@PathVariable("id") Integer id, Model model) {
		citaService.eliminarCita(id);
		return "redirect:/citas/lista";
	}
	
	@GetMapping("/info/{id}")
	public String infoCita (@PathVariable("id") Integer id, Model model) {
		Cita cita = citaService.obtenerCita(id);
		model.addAttribute("dataCita", cita);
		return "cita/cita-info";
	}
	
	@GetMapping("/buscar")
	public String buscarCita (@RequestParam("fecha") String fecha, Model model) {
		List<Cita> citas = citaService.obtenerCitaPorFecha(fecha);
		model.addAttribute("dataCitas", citas);
		model.addAttribute("cantReg", citas.size());
		return "cita/cita-lista";
	}
}
