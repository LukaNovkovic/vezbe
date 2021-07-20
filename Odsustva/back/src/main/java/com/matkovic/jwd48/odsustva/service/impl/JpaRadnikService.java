package com.matkovic.jwd48.odsustva.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.matkovic.jwd48.odsustva.model.Radnik;
import com.matkovic.jwd48.odsustva.model.Odsustvo;
import com.matkovic.jwd48.odsustva.repository.RadnikRepository;
import com.matkovic.jwd48.odsustva.repository.OdsustvoRepository;
import com.matkovic.jwd48.odsustva.service.RadnikService;
import com.matkovic.jwd48.odsustva.service.OdsustvoService;

@Service
public class JpaRadnikService implements RadnikService{
	
	@Autowired
	RadnikRepository radnikRepository;
	
	@Autowired
	OdsustvoService odsustvoService;
	
	@Autowired
	OdsustvoRepository odsustvoRepository;

	@Override
	public Radnik findOne(Long id) {
		// TODO Auto-generated method stub
		return radnikRepository.findOneById(id);
	}

	@Override
	public List<Radnik> findAll() {
		// TODO Auto-generated method stub
		return radnikRepository.findAll();
	}

	@Override
	public Page<Radnik> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return radnikRepository.findAll(pageable);
	}

	@Override
	public Radnik save(Radnik radnik) {
		
		return radnikRepository.save(radnik);
	}



	@Override
	public Radnik update(Radnik radnik) {

		return radnikRepository.save(radnik);
	}

	@Override
	public Radnik delete(Long id) {
		// TODO Auto-generated method stub
		Optional<Radnik> radnikOPT = radnikRepository.findById(id);
		if(radnikOPT.isPresent()) {
			Radnik radnik = radnikOPT.get();
			radnik.getOdeljenje().getRadnici().remove(radnik);
			radnik.getOdsustva().remove(radnik);
		
			radnikRepository.delete(radnik);
			return radnik;
		}
		return null;
	}

	@Override
	public 	    Page<Radnik> search(Long odeljenjeId, String jmbg, int pageNo) {
		// TODO Auto-generated method stub
		
		return radnikRepository.search(odeljenjeId, jmbg, PageRequest.of(pageNo, 4));
	}



}
