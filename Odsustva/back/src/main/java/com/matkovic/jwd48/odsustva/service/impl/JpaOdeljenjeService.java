package com.matkovic.jwd48.odsustva.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.matkovic.jwd48.odsustva.model.Odeljenje;
import com.matkovic.jwd48.odsustva.repository.OdeljenjeRepository;
import com.matkovic.jwd48.odsustva.service.OdeljenjeService;

@Service
public class JpaOdeljenjeService implements OdeljenjeService{
	
	@Autowired 
	OdeljenjeRepository odeljenjeRepository;
	

	@Override
	public Odeljenje findOne(Long id) {
		// TODO Auto-generated method stub
		return odeljenjeRepository.findOneById(id);
	}

	@Override
	public List<Odeljenje> findAll() {
		// TODO Auto-generated method stub
		return odeljenjeRepository.findAll();
	}

	@Override
	public Page<Odeljenje> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return odeljenjeRepository.findAll(pageable);
	}

	@Override
	public Odeljenje save(Odeljenje odeljenje) {
		// TODO Auto-generated method stub
		return odeljenjeRepository.save(odeljenje);
	}

	@Override
	public Odeljenje update(Odeljenje odeljenje) {
		// TODO Auto-generated method stub
		return odeljenjeRepository.save(odeljenje);
	}

	@Override
	public Odeljenje delete(Long id) {
		// TODO Auto-generated method stub
		Odeljenje odeljenje = findOne(id);
		if(odeljenje != null) {
			odeljenjeRepository.deleteById(id);
			return odeljenje;
		}	
		return null;
	}





}
