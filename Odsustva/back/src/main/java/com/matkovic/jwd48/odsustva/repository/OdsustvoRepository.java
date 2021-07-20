package com.matkovic.jwd48.odsustva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matkovic.jwd48.odsustva.model.Odsustvo;

@Repository
public interface OdsustvoRepository extends JpaRepository<Odsustvo,Long>{
	
	Odsustvo findOneById(Long id);
	
	Odsustvo findByRadnikId(Long id);

	
}
