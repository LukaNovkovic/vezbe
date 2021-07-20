package com.matkovic.jwd48.odsustva.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.matkovic.jwd48.odsustva.model.Odsustvo;
import com.matkovic.jwd48.odsustva.repository.OdsustvoRepository;
import com.matkovic.jwd48.odsustva.service.OdsustvoService;

@Service
public class JpaOdsustvoService implements OdsustvoService{

	@Autowired
	OdsustvoRepository odsustvoRepository;

	@Override
	public Odsustvo findOne(Long id) {
		// TODO Auto-generated method stub
		return odsustvoRepository.findOneById(id);
	}

	@Override
	public List<Odsustvo> findAll() {
		// TODO Auto-generated method stub
		return odsustvoRepository.findAll();
	}

	@Override
	public Page<Odsustvo> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return odsustvoRepository.findAll(pageable);
	}

	@Override
	public Odsustvo save(Odsustvo odsustvo) {
		// TODO Auto-generated method stub
		return odsustvoRepository.save(odsustvo);
	}

	@Override
	public Odsustvo update(Odsustvo odsustvo) {
		// TODO Auto-generated method stub
		
		return odsustvoRepository.save(odsustvo);
	}

	@Override
	public Odsustvo delete(Long id) {
		// TODO Auto-generated method stub
		Odsustvo odsustvo = findOne(id);
		if(odsustvo != null) {
			odsustvoRepository.deleteById(id);
			return odsustvo;
		}
		return null;
	}

	@Override
	public Odsustvo findByRadnikId(Long id) {
		// TODO Auto-generated method stub
		return odsustvoRepository.findByRadnikId(id);
	}
}
