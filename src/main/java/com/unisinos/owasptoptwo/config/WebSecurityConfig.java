package com.unisinos.owasptoptwo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) ->
				requests.anyRequest().authenticated()
		).httpBasic(withDefaults());

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		// CWE-311: Missing Encryption of Sensitive Data
		return NoOpPasswordEncoder.getInstance();
	}

}
