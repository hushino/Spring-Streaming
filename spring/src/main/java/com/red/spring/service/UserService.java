package com.red.spring.service;

import com.red.spring.entity.User;
import com.red.spring.repository.GestorUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserService implements UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user =  repo.findByUser(username);
		return new org.springframework.security.core.userdetails.User(user.getUser(),user.getPassword(),user.isActivo(),user.isActivo(),user.isActivo(),user.isActivo(),buildGranted(user.getRol()));
	}
	
	private List<GrantedAuthority> buildGranted(byte rol){
		
		String[] roles={"LECTOR","USUARIO","ADMINISTRADOR"};
		
		List<GrantedAuthority> auths = new ArrayList<>();
		
		for ( int i = 0; i<rol; i++){
			auths.add(new SimpleGrantedAuthority(roles[i]));
		}
		
		return auths;
	}
	
	@Autowired
	@Qualifier("gestorUsuario")
	private GestorUser repo;
}
