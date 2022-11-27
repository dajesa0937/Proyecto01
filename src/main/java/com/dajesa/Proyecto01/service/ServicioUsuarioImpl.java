package com.dajesa.Proyecto01.service;

import com.dajesa.Proyecto01.model.Usuario;
import com.dajesa.Proyecto01.repository.RepositoryUsuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@AllArgsConstructor

public class ServicioUsuarioImpl implements ServiceUser {
    private final RepositoryUsuario repositoryUsuario;

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return repositoryUsuario.save(usuario);
    }

    @Override
    public Usuario obtenerUsuario(Long idUsuario) {
        return repositoryUsuario.findById(idUsuario).orElseThrow(()-> {throw new RuntimeException();});
    }

    @Override
    public Usuario usuarioAeditar(Long id, Usuario usuarioEditar) {
        Usuario usuarioBuscado = repositoryUsuario.findById(id).get();
        usuarioBuscado.setNombre(usuarioEditar.getNombre());
        usuarioBuscado.setApellido(usuarioEditar.getApellido());
        usuarioBuscado.setTelefono(usuarioEditar.getTelefono());
        usuarioBuscado.setDireccion(usuarioEditar.getDireccion());
        return repositoryUsuario.save(usuarioBuscado);
    }

    @Override
    public boolean eliminarUsuario(Long id) {
        try{
            repositoryUsuario.deleteAllById(Collections.singleton(id));
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
