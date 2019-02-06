package com.llb.epoch.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Adm").password("123").roles("CADASTRAR_PRODUTO", "LISTAR_PRODUTOS").and()
		.withUser("Comum").password("123").roles("CADASTRAR_PRODUTO");
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/layout/**");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/produtos/novo").hasRole("CADASTRAR_PRODUTO")
		.antMatchers("/produtos/**").hasRole("LISTAR_PRODUTOS")
		.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout().
		logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}
}
