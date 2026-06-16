package com.example.ControlDeCitas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ControlDeCitas.model.Usuario;
import com.example.ControlDeCitas.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	// Inyección de dependencias por constructor (Recomendado en Spring)
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Valida las credenciales de un usuario.
     */
    public List<Usuario> validarUsuario(String username, String clave) {
        return usuarioRepository.validarUsuario(username, clave);
    }

    /**
     * Obtiene la lista completa de usuarios con su tipo.
     */
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.obtenerTodosLosUsuarios();
    }

    /**
     * Busca un usuario específico por su ID.
     */
    public Optional<Usuario> obtenerUsuarioPorId(Long idUsuario) {
        return usuarioRepository.obtenerUsuarioPorId(idUsuario);
    }

    /**
     * Registra un nuevo usuario en el sistema.
     */
    public void registrarUsuario(String username, String clave, Integer idTipo) {
        usuarioRepository.registrarUsuario(username, clave, idTipo);
    }

    /**
     * Actualiza los datos de un usuario existente.
     */
    public void actualizarUsuario(String username, String clave, Integer idTipo, Long idUsuario) {
        usuarioRepository.actualizarUsuario(username, clave, idTipo, idUsuario);
    }

    /**
     * Elimina un usuario del sistema mediante su ID.
     */
    public void eliminarUsuario(Long idUsuario) {
        usuarioRepository.eliminarUsuario(idUsuario);
    }
	
}
