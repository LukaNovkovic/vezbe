package com.matkovic.jwd48.odsustva.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.matkovic.jwd48.odsustva.model.Radnik;

public interface RadnikService {
	 	
		Radnik findOne(Long id);

	    List<Radnik> findAll();

	    Page<Radnik> findAll(Pageable pageable);

	    Radnik save(Radnik sprint);

	    Radnik update(Radnik sprint);

	    Radnik delete(Long id);
	    
	    Page<Radnik> search(Long odeljenjeId, String jmbg, int pageNo);

//		Integer saberiBodovePoSprintu(Long sprintId);

}
