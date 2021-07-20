package com.matkovic.jwd48.odsustva.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.matkovic.jwd48.odsustva.model.Adresa;
import com.matkovic.jwd48.odsustva.service.AdresaService;
import com.matkovic.jwd48.odsustva.web.dto.AdresaDTO;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public class AdresaDtoToAdresa implements Converter<AdresaDTO, Adresa> {

    @Autowired
    private AdresaService adresaService;

    @Override
    public Adresa convert(AdresaDTO adresaDto) {
        Adresa entity = null;

        if(adresaDto.getId() == null) {
            entity = new Adresa();
        }else {
            Optional<Adresa> adresaOptional = adresaService.findOne(adresaDto.getId());
            if(adresaOptional.isPresent()){
                entity = adresaOptional.get();
            }
        }

        if(entity != null) {
            entity.setId(adresaDto.getId());
            entity.setBroj(adresaDto.getBroj());
            entity.setUlica(adresaDto.getUlica());
        }

        return entity;
    }

}

