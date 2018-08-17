package com.red.spring.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user")
public class User  implements Serializable {
	
	@GeneratedValue
	@Id
	@Column(unique = true)
	private long id;
	
	@Column(unique = true)
	private String user;
	
	private String password;
	
	@Column(name="ROL")
	private byte rol;
	
	@Column(name="Activo")
	private boolean activo;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public byte getRol() {
		return rol;
	}
	
	public void setRol(byte rol) {
		this.rol = rol;
	}
	
	public boolean isActivo() {
		return activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
