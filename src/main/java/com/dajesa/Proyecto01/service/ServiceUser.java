package com.dajesa.Proyecto01.service;

import com.dajesa.Proyecto01.model.Usuario;

public interface ServiceUser {
    Usuario guardarUsuario(Usuario usuario);
    Usuario obtenerUsuario(Long idUsuario);
    Usuario usuarioAeditar(Long id, Usuario usuarioEditar);
    boolean eliminarUsuario(Long id);

}
