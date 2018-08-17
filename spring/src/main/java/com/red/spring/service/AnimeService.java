package com.red.spring.service;

import com.red.spring.converter.Converter;
import com.red.spring.entity.Anime;
import com.red.spring.model.MAnime;
import com.red.spring.repository.AnimeRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

//creamos la plantilla de una inferfaz de como va ser el service y luego lo implementamos en una clase
@Service("service")
public class AnimeService {
	
	private static final Log logger = LogFactory.getLog("AnimeService.class");
	
	@Autowired
	@Qualifier("repository")
	private AnimeRepository repository;
	
	@Autowired
	@Qualifier("converter")
	private Converter converter;
	
	public boolean crear(Anime anime){
		logger.info("Creando Anime");
		try {
			repository.save(anime);
			logger.info("Anime creado");
			return true;
		}catch ( Exception e ){
			return false;
		}
	}
	public boolean actualizar(Anime anime){
		try {
			repository.save(anime);
			return true;
		}catch ( Exception e ){
			return false;
		}
	}
	public boolean borrar(String title, long id){
		try {
			Anime anime = repository.findByTitleAndId(title, id);
			repository.delete(anime);
			return true;
		}catch ( Exception e ){
			return false;
		}
	}
	
	public List< MAnime > obtener(){
		return converter.convertirLista(repository.findAll(Sort.by("createDate").ascending()));
	}
	
	public MAnime obtenerPorNombreTitulo(String title, String frontimage){
		return  new MAnime(repository.findByTitleAndFrontimage(title,frontimage));
	}
	public List< MAnime > obtenerTitulo(String title){
		return converter.convertirLista(( List< Anime > ) repository.findByTitle(title));
	}
	
	//http://localhost:8080/v1/animes?page=0&size=5
	public List<MAnime> obtenerPorPaginacion(Pageable pageable){
		return converter.convertirLista(repository.findAll(pageable).getContent());
	}
}
