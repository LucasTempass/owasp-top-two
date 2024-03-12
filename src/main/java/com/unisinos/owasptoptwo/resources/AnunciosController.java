package com.unisinos.owasptoptwo.resources;

import com.unisinos.owasptoptwo.model.Anuncio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
@RequestMapping("/anuncios")
public class AnunciosController {

	@GetMapping
	public Collection<Anuncio> getAnunciosByTitulo(@RequestParam String title) {
		// TODO implementar
		return Collections.emptyList();
	}

	@GetMapping("/{id}")
	public Anuncio getAnuncio(@PathVariable Integer id) {
		// TODO implementar
		return new Anuncio();
	}

	@PostMapping
	public Anuncio createAnuncio(@RequestBody Anuncio anuncio) {
		// TODO implementar
		return anuncio;
	}

	@PutMapping("/{id}")
	public Anuncio updateAnuncio(@PathVariable Integer id, @RequestBody Anuncio anuncio) {
		// TODO implementar
		return anuncio;
	}

	@DeleteMapping("/{id}")
	public void deleteAnuncio(@PathVariable Integer id) {
		// TODO implementar
	}


}
