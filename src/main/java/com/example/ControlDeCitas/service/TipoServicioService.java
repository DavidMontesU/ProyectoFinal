package com.example.ControlDeCitas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ControlDeCitas.model.TipoServicio;
import com.example.ControlDeCitas.repository.TipoServicioRepository;

@Service
public class TipoServicioService {

    private final TipoServicioRepository tipoServicioRepository;

    // Inyección de dependencias por constructor
    public TipoServicioService(TipoServicioRepository tipoServicioRepository) {
        this.tipoServicioRepository = tipoServicioRepository;
    }

    /**
     * Obtiene la lista completa de todos los tipos de servicio disponibles.
     */
    public List<TipoServicio> listarTiposServicios() {
        return tipoServicioRepository.listarTiposServicios();
    }

    /**
     * Busca un tipo de servicio específico mediante su ID.
     */
    public Optional<TipoServicio> obtenerTipoServicioPorId(Integer idTipoServicio) {
        return tipoServicioRepository.obtenerTipoServicioPorId(idTipoServicio);
    }

    /**
     * Registra un nuevo tipo de servicio en el sistema.
     */
    public void registrarTipoServicio(String descripcion, Double precio) {
        tipoServicioRepository.registrarTipoServicio(descripcion, precio);
    }

    /**
     * Actualiza los datos (descripción y precio) de un tipo de servicio existente.
     */
    public void actualizarTipoServicio(String descripcion, Double precio, Integer idTipoServicio) {
        tipoServicioRepository.actualizarTipoServicio(descripcion, precio, idTipoServicio);
    }

    /**
     * Elimina un tipo de servicio del sistema mediante su ID.
     */
    public void eliminarTipoServicio(Integer idTipoServicio) {
        tipoServicioRepository.eliminarTipoServicio(idTipoServicio);
    }
}