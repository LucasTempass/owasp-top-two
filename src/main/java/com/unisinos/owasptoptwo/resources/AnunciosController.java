package com.unisinos.owasptoptwo.resources;

import com.unisinos.owasptoptwo.dto.AnuncioDetails;
import com.unisinos.owasptoptwo.model.Anuncio;
import com.unisinos.owasptoptwo.service.AnuncioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/anuncios")
public class AnunciosController {

	private final AnuncioService anuncioService;

	@GetMapping("/{id}")
	public AnuncioDetails getAnuncio(@PathVariable Integer id) {
		// CWE-200: Exposure of Sensitive Information to an Unauthorized Actor (Corrigida)
		return anuncioService.findById(id).map(
				anuncio -> new AnuncioDetails(anuncio.getTitulo(), anuncio.getDescricao(),
						anuncio.isAtivo(), anuncio.getId())
		).orElse(null);
	}

	@PutMapping("/{id}")
	public void updateAnuncio(@PathVariable Integer id, @RequestBody Anuncio anuncio) {
		// CWE-862: Missing Authorization (Corrigida)
		anuncioService.update(id, anuncio);
	}

	@DeleteMapping("/{id}")
	public void deleteAnuncio(@PathVariable Integer id) {
		// CWE-862: Missing Authorization (Corrigida)
		anuncioService.delete(id);
	}

	@PostMapping
	public Integer createAnuncio(@RequestBody Anuncio anuncio) {
		return anuncioService.create(anuncio);
	}

}
