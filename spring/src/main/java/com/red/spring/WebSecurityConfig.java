package com.red.spring;

/*
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http
				.authorizeRequests()
					.antMatchers("/", "home").permitAll()
					.anyRequest().authenticated()
					.and()
				.authorizeRequests()
					.antMatchers("/greeting").permitAll()
					.anyRequest().permitAll()
					.and()
				.formLogin()
					.loginPage("/login")
					.permitAll()
					.and()
				.logout()
					.permitAll();
	}
	@Bean
	@Override
	public UserDetailsService userDetailsService(){
		UserDetails user =
				User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();
		return  new InMemoryUserDetailsManager(user);
	}
	
}*/
