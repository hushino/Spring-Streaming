package com.red.spring.repository;

import com.red.spring.entity.Anime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("repository")
public interface AnimeRepository extends JpaRepository< Anime, Serializable >, PagingAndSortingRepository<Anime, Serializable> {
	
	  Anime findByTitle(String title);
	 List<Anime> findByFrontimage(String frontimage);
	 Anime findByTitleAndFrontimage(String title, String frontimage);
	 Anime findByTitleAndId(String title,long id);
	 
	 Page<Anime> findAll(Pageable pageable);
	 
}

