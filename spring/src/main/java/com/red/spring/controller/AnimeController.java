package com.red.spring.controller;

import com.red.spring.entity.Anime;
import com.red.spring.model.MAnime;
import com.red.spring.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class AnimeController {
	
	private final
	AnimeService service;
	
	@Autowired
	public AnimeController(@Qualifier( "service" ) AnimeService service) {
		this.service = service;
	}
	
	@PutMapping("/anime")
	public boolean agregarAnime(@RequestBody @Valid Anime anime){
		return service.crear(anime);
	}
	
	@PutMapping("/anime/update")
	public boolean actualizarAnime(@RequestBody @Valid Anime anime){
		return service.actualizar(anime);
	}
	
	@DeleteMapping("/anime/{id}/{title}")
	public boolean borrarAnime(@PathVariable("id") long id,@PathVariable("title") String title){
		return service.borrar(title,id);
	}
	
	/*@GetMapping("/animes")
	public List<MAnime> obtenerAnimes(){
		return service.obtener();
	}*/
	
	@GetMapping("/animes")
	public List<MAnime> obtenerAnimes(Pageable pageable){
		return service.obtenerPorPaginacion(pageable);
	}
	
}
