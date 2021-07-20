package com.matkovic.jwd48.odsustva.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matkovic.jwd48.odsustva.model.Adresa;
import com.matkovic.jwd48.odsustva.repository.AdresaRepository;
import com.matkovic.jwd48.odsustva.service.AdresaService;

import java.util.List;
import java.util.Optional;

@Service
public class JpaAdresaService implements AdresaService {
    @Autowired
    private AdresaRepository adresaRepository;

    @Override
    public Optional<Adresa> findOne(Long id) {
        return adresaRepository.findById(id);
    }

    @Override
    public List<Adresa> findAll() {
        return adresaRepository.findAll();
    }

    @Override
    public Adresa save(Adresa adresa) {
        return adresaRepository.save(adresa);
    }

    @Override
    public void delete(Long id) {
        adresaRepository.deleteById(id);
    }

}
