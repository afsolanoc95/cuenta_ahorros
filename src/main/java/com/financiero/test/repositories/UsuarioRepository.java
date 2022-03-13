package com.financiero.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financiero.test.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	Usuario findByUsername(String username);
}
