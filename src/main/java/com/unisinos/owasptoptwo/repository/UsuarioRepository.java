package com.unisinos.owasptoptwo.repository;

import com.unisinos.owasptoptwo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	Optional<Usuario> findFirstByEmailIgnoreCase(String email);

}