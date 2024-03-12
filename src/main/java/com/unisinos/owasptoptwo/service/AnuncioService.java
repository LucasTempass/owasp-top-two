package com.unisinos.owasptoptwo.service;

import com.unisinos.owasptoptwo.config.CustomUserDetails;
import com.unisinos.owasptoptwo.model.Anuncio;
import com.unisinos.owasptoptwo.repository.AnuncioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnuncioService {

	private final AnuncioRepository anuncioRepository;

	public Optional<Anuncio> findById(Integer id) {
		return anuncioRepository.findById(id);
	}

	public Integer create(Anuncio anuncio) {
		return anuncioRepository.save(anuncio).getId();
	}

	public void update(Integer id, Anuncio anuncio) {
		var anuncioDesatualizado = anuncioRepository.findById(id).orElseThrow();

		var user = getUsuarioLogado();

		if (anuncioDesatualizado.getDono().getId() != user.getId()) {
			throw new RuntimeException("Usuário não autorizado a atualizar o anúncio.");
		}

		anuncioDesatualizado.setTitulo(anuncio.getTitulo());
		anuncioDesatualizado.setDescricao(anuncio.getDescricao());
		anuncioDesatualizado.setDono(anuncio.getDono());
		anuncioDesatualizado.setAtivo(anuncio.isAtivo());

		anuncioRepository.save(anuncioDesatualizado);
	}


	public void delete(Integer id) {
		var user = getUsuarioLogado();

		var anuncio = anuncioRepository.findById(id).orElseThrow();

		if (anuncio.getDono().getId() != user.getId()) {
			throw new RuntimeException("Usuário não autorizado a atualizar o anúncio.");
		}

		anuncioRepository.deleteById(id);
	}

	private CustomUserDetails getUsuarioLogado() {
		return (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

}
