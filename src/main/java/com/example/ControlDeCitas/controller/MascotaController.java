package com.example.ControlDeCitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ControlDeCitas.model.Mascota;
import com.example.ControlDeCitas.service.MascotaService;
import com.example.ControlDeCitas.service.ClienteService;
import com.example.ControlDeCitas.service.EspecieService;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    MascotaService mascotaService;
    
    @Autowired
    ClienteService clienteService;
    
    @Autowired
    EspecieService especieService;

    @GetMapping("/lista")
    public String listar(Model model) {
        List<Mascota> mascotas = mascotaService.listarTodos();
        model.addAttribute("dataMascota", mascotas);
        model.addAttribute("cantReg", mascotas.size());
        model.addAttribute("titulo", "Listado de Mascotas");
        model.addAttribute("content", "mascota/mascotaList");
        return "layout";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("mascotaDataEdit", new Mascota());
        model.addAttribute("dataEspecie", especieService.listarTodas());
        model.addAttribute("dataCliente", clienteService.listarTodos());
        model.addAttribute("titulo", "Registrar Mascota");
        model.addAttribute("content", "mascota/mascotaNueva");
        return "layout";
    }

    @PostMapping("/registrar")
    public String guardar(@ModelAttribute("mascotaDataEdit") Mascota mascota, Model model, RedirectAttributes ra) {
        try {
            if (mascota.getIdMascota() > 0) {
                mascotaService.actualizarMascota(mascota);
            } else {
                mascotaService.registrarMascota(mascota);
            }
            ra.addFlashAttribute("msgExito", "Mascota guardada correctamente.");
            return "redirect:/mascotas/lista";
        } catch (Exception e) {
            model.addAttribute("msgError", e.getMessage());
            model.addAttribute("mascotaDataEdit", mascota);
            model.addAttribute("dataEspecie", especieService.listarTodas());
            model.addAttribute("dataCliente", clienteService.listarTodos());
            model.addAttribute("content", (mascota.getIdMascota() > 0) ? "mascota/mascotaEdit" : "mascota/mascotaNueva");
            return "layout";
        }
    }

    @GetMapping("/infoEdit/{id}")
    public String obtenerEdit(@PathVariable("id") Integer id, Model model) {
        Mascota mascota = mascotaService.obtenerMascota(id);
        model.addAttribute("mascotaDataEdit", mascota);
        model.addAttribute("dataEspecie", especieService.listarTodas());
        model.addAttribute("dataCliente", clienteService.listarTodos());
        model.addAttribute("titulo", "Editar Mascota");
        model.addAttribute("content", "mascota/mascotaEdit");
        return "layout";
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable("id") Integer id, Model model) {
        Mascota mascota = mascotaService.obtenerMascota(id);
        model.addAttribute("mascotaData", mascota);
        model.addAttribute("titulo", "Información de la Mascota");
        model.addAttribute("content", "mascota/mascotaInfo");
        return "layout";
    }

    @PostMapping("/eliminar")
    public String eliminar(@RequestParam("id") Integer id) {
        mascotaService.eliminarMascota(id);
        return "redirect:/mascotas/lista";
    }

    @PostMapping("/buscar")
    public String buscar(@RequestParam("txtBuscar") String txtBuscar, Model model) {
        List<Mascota> mascotas = mascotaService.buscarMascotaByNombre(txtBuscar);
        model.addAttribute("dataMascota", mascotas);
        model.addAttribute("cantReg", mascotas.size());
        model.addAttribute("titulo", "Listado de Mascotas");
        model.addAttribute("content", "mascota/mascotaList");
        return "layout";
    }
}
