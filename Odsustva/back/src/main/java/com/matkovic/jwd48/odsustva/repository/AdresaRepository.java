package com.matkovic.jwd48.odsustva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.matkovic.jwd48.odsustva.model.Adresa;


@Repository
public interface AdresaRepository extends JpaRepository<Adresa, Long> {

}
