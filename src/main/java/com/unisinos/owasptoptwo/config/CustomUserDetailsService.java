package com.unisinos.owasptoptwo.config;

import com.unisinos.owasptoptwo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UsuarioRepository usuarioRepository;

	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var usuario = usuarioRepository.findFirstByEmailIgnoreCase(username)
				.orElseThrow(() -> new UsernameNotFoundException("Não foi possível encontrar o usuário informado."));

		return new CustomUserDetails(usuario.getSenha(), usuario.getEmail(), usuario.getId());
	}


}
