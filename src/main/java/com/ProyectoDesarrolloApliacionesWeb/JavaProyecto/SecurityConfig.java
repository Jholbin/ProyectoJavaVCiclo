package com.ProyectoDesarrolloApliacionesWeb.JavaProyecto;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	@Bean
	public UserDetailsService userDetailService() {
		User jholbin = new User("jholbin",
         getPasswordEncoder().encode("123456"),
         Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));

         User jhin = new User("jhin",
         getPasswordEncoder().encode("123456"),
         Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));

		 User nilo = new User("nilo",
         getPasswordEncoder().encode("123456"),
         Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));

        return new InMemoryUserDetailsManager(jholbin, jhin, nilo);
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		return httpSecurity
		.authorizeHttpRequests(authorizeHttpRequests -> 
			authorizeHttpRequests
				.requestMatchers("/", "/about", "/fagments/head", "/css/style.css","/img/**").permitAll()
				.requestMatchers("/products").authenticated()
				.requestMatchers("/products/downloadReport").authenticated()
				.requestMatchers("/products/registerProduct", "/products/deleteProduct/{id}").authenticated()
				.requestMatchers("/products/searchcat", "/products/search").authenticated()
				.requestMatchers("products/frmUpdateProduct/{id}").authenticated()
				.requestMatchers("/usuarios").authenticated()
				.requestMatchers("/usuarios/downloadReporte").authenticated()
				.requestMatchers("/usuarios/registerUsuario", "/usuarios/deleteUsuario/{id}").authenticated()
				.requestMatchers("usuarios/frmUpdateUsuario/{id}").authenticated()

			)
			.formLogin(formLogin -> formLogin.loginPage("/user/login").permitAll())
			.build();
		
	}

}
