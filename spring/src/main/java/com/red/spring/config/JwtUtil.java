package com.red.spring.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

import static java.util.Collections.emptyList;

public class JwtUtil {
	
	// Método para crear el JWT y enviarlo al cliente en el header de la respuesta
	static void addAuthentication(HttpServletResponse res, String username) {
		
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS512;
		String key = "BANANAFiSH";
		
		int expirationTime = 1;
		final Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MINUTE, expirationTime);
		
		String token = Jwts.builder()
				.setSubject(username)
				.setExpiration(calendar.getTime())
				// Hash con el que firmaremos la clave
				.signWith(signatureAlgorithm, key)
				.compact();
		
		//agregamos al encabezado el token
		res.addHeader("Authorization", "Bearer " + token);
	}
	
	// Método para validar el token enviado por el cliente
	static Authentication getAuthentication(HttpServletRequest request) {
		
		// Obtenemos el token que viene en el encabezado de la peticion
		String token = request.getHeader("Authorization");
		
		// si hay un token presente, entonces lo validamos
		if (token != null) {
			String user = Jwts.parser()
					.setSigningKey("P@tit0")
					.parseClaimsJws(token.replace("Bearer", "")) //este metodo es el que valida
					.getBody()
					.getSubject();
			
			// Recordamos que para las demás peticiones que no sean /login
			// no requerimos una autenticacion por username/password
			// por este motivo podemos devolver un UsernamePasswordAuthenticationToken sin password
			return user != null ?
					new UsernamePasswordAuthenticationToken(user, null, emptyList()) :
					null;
		}
		return null;
	}
}
