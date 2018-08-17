package com.red.spring.repository;

import com.red.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("gestorUsuario")
public interface GestorUser extends JpaRepository<User, Serializable> {
	User findByUser(String user);
}
