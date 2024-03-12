package com.unisinos.owasptoptwo.config;

import com.unisinos.owasptoptwo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

	private final UsuarioRepository usuarioRepository;

	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var usuario = usuarioRepository.findFirstByEmailIgnoreCase(username)
				.orElseThrow(() -> new UsernameNotFoundException("Não foi possível encontrar o usuário informado."));

		return new CustomUserDetails(usuario.getSenha(), usuario.getEmail());
	}

	@RequiredArgsConstructor
	public static class CustomUserDetails implements UserDetails {

		private final String password;
		private final String username;

		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
		}

		@Override
		public String getPassword() {
			return password;
		}

		@Override
		public String getUsername() {
			return username;
		}

		@Override
		public boolean isAccountNonExpired() {
			return true;
		}

		@Override
		public boolean isAccountNonLocked() {
			return true;
		}

		@Override
		public boolean isCredentialsNonExpired() {
			return true;
		}

		@Override
		public boolean isEnabled() {
			return true;
		}
	}

}
