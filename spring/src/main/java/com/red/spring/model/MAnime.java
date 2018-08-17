package com.red.spring.model;

import com.red.spring.entity.Anime;

public class MAnime {
	
	/*
	Modelo no esta declarrado con las anotaciones.
	Las entidades se van a trabajar en los repositorios
	y los modelos se trabajan en el controlador o service
	por medio de un converter vamos a convertir de entidad a modello y viceversa
	*/
	private Long id;
	private  String title;
	private String synopsis;
	private String state;
	private String type;
	private String frontimage;
	private String backgroundimage;
	
	public MAnime(){}
	
	// convertir una entidad a un modelo, el convertir sirve para convertir listas y demas
	public MAnime(Anime anime){
		this.id = anime.getId();
		this.title = anime.getTitle();
		this.synopsis = anime.getSynopsis();
		this.state = anime.getState();
		this.type = anime.getType();
		this.frontimage = anime.getFrontimage();
		this.backgroundimage = anime.getBackgroundimage();
	}
	
	public MAnime(Long id, String title, String synopsis, String state, String type, String frontimage, String backgroundimage) {
		this.id = id;
		this.title = title;
		this.synopsis = synopsis;
		this.state = state;
		this.type = type;
		this.frontimage = frontimage;
		this.backgroundimage = backgroundimage;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSynopsis() {
		return synopsis;
	}
	
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getFrontimage() {
		return frontimage;
	}
	
	public void setFrontimage(String frontimage) {
		this.frontimage = frontimage;
	}
	
	public String getBackgroundimage() {
		return backgroundimage;
	}
	
	public void setBackgroundimage(String backgroundimage) {
		this.backgroundimage = backgroundimage;
	}
}
