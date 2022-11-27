package com.dajesa.Proyecto01.controller;

import com.dajesa.Proyecto01.model.Usuario;
import com.dajesa.Proyecto01.service.ServiceUser;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor

public class ControllerUser {
    private final ServiceUser serviceUser;

    @PostMapping
    public ResponseEntity guardarUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity(serviceUser.guardarUsuario(usuario), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity obtenerUsuario(@PathVariable("id") Long idUsuario) {
        return new ResponseEntity(serviceUser.obtenerUsuario(idUsuario), HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity usuarioAeditar(@PathVariable("id") Long idUsuario, @RequestBody Usuario usuario) {
        return new ResponseEntity(serviceUser.usuarioAeditar(idUsuario, usuario), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarUsuario(@PathVariable("id") Long idUsuario) {
        boolean respuesta = serviceUser.eliminarUsuario(idUsuario);
        if (respuesta == true) {
            return new ResponseEntity(HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}