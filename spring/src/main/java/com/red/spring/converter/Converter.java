package com.red.spring.converter;

import com.red.spring.entity.Anime;
import com.red.spring.model.MAnime;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
// de una lista entidad a modelo
@Component("converter")
public class Converter {
	public List<MAnime> convertirLista(List<Anime> animes){
		List<MAnime> mAnimes = new ArrayList<>();
		
		for (Anime anime : animes){
			mAnimes.add(new MAnime(anime));
		}
		
		return mAnimes;
	}
}
