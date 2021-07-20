package com.matkovic.jwd48.odsustva.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.matkovic.jwd48.odsustva.model.Odeljenje;

import java.util.List;

public interface OdeljenjeService {

    Odeljenje findOne(Long id);

    List<Odeljenje> findAll();

    Page<Odeljenje> findAll(Pageable pageable);

    Odeljenje save(Odeljenje odeljenje);

    Odeljenje update(Odeljenje odeljenje);

    Odeljenje delete(Long id);

//    Page<Sprint> find(String ime, Integer ukupnoBodova, int page);

}
