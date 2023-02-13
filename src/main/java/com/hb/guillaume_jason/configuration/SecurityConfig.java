package com.hb.guillaume_jason.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {		
		
		http.authorizeHttpRequests()
			.requestMatchers("/").permitAll()
			.requestMatchers("/register").permitAll()
			.anyRequest().authenticated()
			.and().formLogin();
		
		return http.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(
			HttpSecurity http, 
			BCryptPasswordEncoder bCryptPasswordEncoder, 
			UserDetailsService userDetailService) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailService)
				.passwordEncoder(bCryptPasswordEncoder)
				.and().build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
