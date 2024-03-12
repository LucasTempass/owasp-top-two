package com.unisinos.owasptoptwo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Anuncio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "titulo", nullable = false, length = 128)
	private String titulo;

	@Column(name = "descricao", nullable = false, length = 1024)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "dono_id", nullable = false)
	private Usuario dono;

	@Column(name = "is_ativo", nullable = false)
	private boolean ativo;

}
