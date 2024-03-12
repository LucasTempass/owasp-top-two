package com.unisinos.owasptoptwo.resources;

import com.unisinos.owasptoptwo.model.Anuncio;
import com.unisinos.owasptoptwo.service.AnuncioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@RequestMapping("/anuncios")
public class AnunciosController {

	private final AnuncioService anuncioService;

	@GetMapping("/{id}")
	public Anuncio getAnuncio(@PathVariable Integer id) {
		// CWE-200: Exposure of Sensitive Information to an Unauthorized Actor
		// Ao retornar a Entidade Anuncio diretamente, estamos expondo informações sensíveis sobre o anúncio e seu dono.
		return anuncioService.findById(id).orElseThrow(() ->
				new ResponseStatusException(HttpStatusCode.valueOf(404), "Não foi possível encontraro  anúncio.")
		);
	}

	@PutMapping("/{id}")
	public void updateAnuncio(@PathVariable Integer id, @RequestBody Anuncio anuncio) {
		// CWE-862: Missing Authorization
		// Não estamos verificando se o usuário que está tentando atualizar o anúncio é o dono do anúncio.
		anuncioService.update(id, anuncio);
	}

	@DeleteMapping("/{id}")
	public void deleteAnuncio(@PathVariable Integer id) {
		// CWE-862: Missing Authorization
		// Não estamos verificando se o usuário que está tentando deletar o anúncio é o dono do anúncio.
		anuncioService.delete(id);
	}

	@PostMapping
	public Integer createAnuncio(@RequestBody Anuncio anuncio) {
		return anuncioService.create(anuncio);
	}

}
