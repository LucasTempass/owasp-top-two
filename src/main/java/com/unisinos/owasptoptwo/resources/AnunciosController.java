package com.unisinos.owasptoptwo.resources;

import com.unisinos.owasptoptwo.model.Anuncio;
import com.unisinos.owasptoptwo.service.AnuncioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/anuncios")
public class AnunciosController {

	private final AnuncioService anuncioService;

	@GetMapping
	public List<Anuncio> getAnunciosByTitulo(@RequestParam String title) {
		return anuncioService.findAllByTitle(title);
	}

	@GetMapping("/{id}")
	public Anuncio getAnuncio(@PathVariable Integer id) {
		return anuncioService.findById(id).orElseThrow(() ->
				new ResponseStatusException(HttpStatusCode.valueOf(404), "Não foi possível encontraro  anúncio.")
		);
	}

	@PostMapping
	public Integer createAnuncio(@RequestBody Anuncio anuncio) {
		return anuncioService.create(anuncio);
	}

	@PutMapping("/{id}")
	public void updateAnuncio(@PathVariable Integer id, @RequestBody Anuncio anuncio) {
		anuncioService.update(id, anuncio);
	}

	@DeleteMapping("/{id}")
	public void deleteAnuncio(@PathVariable Integer id) {
		anuncioService.delete(id);
	}

}
