package com.unisinos.owasptoptwo.service;

import com.unisinos.owasptoptwo.model.Anuncio;
import com.unisinos.owasptoptwo.repository.AnuncioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnuncioService {

	private final AnuncioRepository anuncioRepository;

	public List<Anuncio> findAllByTitle(String title) {
		return anuncioRepository.findAllByTitulo(title);
	}

	public Optional<Anuncio> findById(Integer id) {
		return anuncioRepository.findById(id);
	}

	public Integer create(Anuncio anuncio) {
		return anuncioRepository.save(anuncio).getId();
	}

	public void update(Integer id, Anuncio anuncio) {
		var anuncioDesatualizado = anuncioRepository.findById(id).orElseThrow();

		anuncioDesatualizado.setTitulo(anuncio.getTitulo());
		anuncioDesatualizado.setDescricao(anuncio.getDescricao());
		anuncioDesatualizado.setDono(anuncio.getDono());
		anuncioDesatualizado.setAtivo(anuncio.isAtivo());

		anuncioRepository.save(anuncioDesatualizado);
	}


	public void delete(Integer id) {
		anuncioRepository.deleteById(id);
	}

}
