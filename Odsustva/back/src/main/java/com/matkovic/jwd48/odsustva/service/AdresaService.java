package com.matkovic.jwd48.odsustva.service;

import java.util.List;
import java.util.Optional;

import com.matkovic.jwd48.odsustva.model.Adresa;

public interface AdresaService {

    Optional<Adresa> findOne(Long id);

    List<Adresa> findAll();

    Adresa save(Adresa adresa);

    void delete(Long id);

}
