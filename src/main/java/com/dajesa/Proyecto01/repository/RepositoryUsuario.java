package com.dajesa.Proyecto01.repository;

import com.dajesa.Proyecto01.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RepositoryUsuario extends JpaRepository<Usuario, Long> {

}
