package com.unisinos.owasptoptwo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nome", nullable = false, length = 128)
	private String nome;

	@Column(name = "email", nullable = false, length = 256)
	private String email;

	@Column(name = "senha", nullable = false, length = 64)
	private String senha;

	@OneToMany(mappedBy = "dono", orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Anuncio> anuncios = new ArrayList<>();

}
