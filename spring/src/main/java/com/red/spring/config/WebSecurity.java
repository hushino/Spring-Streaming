package com.red.spring.config;

import com.red.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/login").permitAll()
				.anyRequest().authenticated()
				.and()
				// Las peticiones /login pasaran previamente por este filtro
		.addFilterBefore(new LoginFilter("/login", authenticationManager()),
				UsernamePasswordAuthenticationFilter.class)
				// Las demas peticiones pasaran por este filtro para validad el token
		.addFilterBefore(new JwtFilter(),
				UsernamePasswordAuthenticationFilter.class);
	}
}
