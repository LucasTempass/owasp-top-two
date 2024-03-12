package com.unisinos.owasptoptwo.dto;

public record AnuncioRequest(
		String titulo,
		String descricao,
		boolean ativo
) {
}
