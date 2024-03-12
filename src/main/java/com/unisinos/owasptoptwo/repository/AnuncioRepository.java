package com.unisinos.owasptoptwo.repository;

import com.unisinos.owasptoptwo.model.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnuncioRepository extends JpaRepository<Anuncio, Integer> {

	List<Anuncio> findAllByTitulo(String titulo);

}
