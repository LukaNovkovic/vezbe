package com.matkovic.jwd48.odsustva.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.matkovic.jwd48.odsustva.model.Odsustvo;

public interface OdsustvoService {
	
	Odsustvo findOne(Long id);

    List<Odsustvo> findAll();

    Page<Odsustvo> findAll(Pageable pageable);

    Odsustvo save(Odsustvo odsustvo);

    Odsustvo update(Odsustvo odsustvo);

    Odsustvo delete(Long id);
    
    Odsustvo findByRadnikId(Long id);

}
