package com.matkovic.jwd48.odsustva.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.matkovic.jwd48.odsustva.model.Adresa;
import com.matkovic.jwd48.odsustva.web.dto.AdresaDTO;


@Component
public class AdresaToAdresaDto implements Converter<Adresa, AdresaDTO> {

    @Override
    public AdresaDTO convert(Adresa adresa) {
        AdresaDTO adresaDTO = new AdresaDTO();
        adresaDTO.setId(adresa.getId());
        adresaDTO.setBroj(adresa.getBroj());
        adresaDTO.setUlica(adresa.getUlica());
        return adresaDTO;
    }

    public List<AdresaDTO> convert(List<Adresa> adrese){
        List<AdresaDTO> adresaDTOS = new ArrayList<>();

        for(Adresa a : adrese) {
            AdresaDTO dto = convert(a);
            adresaDTOS.add(dto);
        }

        return adresaDTOS;
    }

}