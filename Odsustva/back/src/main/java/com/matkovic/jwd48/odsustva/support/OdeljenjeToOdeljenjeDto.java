package com.matkovic.jwd48.odsustva.support;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.matkovic.jwd48.odsustva.model.Radnik;
import com.matkovic.jwd48.odsustva.model.Odeljenje;
import com.matkovic.jwd48.odsustva.web.dto.OdeljenjeDTO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class OdeljenjeToOdeljenjeDto implements Converter<Odeljenje, OdeljenjeDTO> {
	

	@Override
	public OdeljenjeDTO convert(Odeljenje odeljenje) {
		// TODO Auto-generated method stub
		OdeljenjeDTO dto = new OdeljenjeDTO();

		dto.setBonus(odeljenje.getBonus());
		dto.setId(odeljenje.getId());
		dto.setIme(odeljenje.getIme());
		
		
	
		return dto;
	}

    public List<OdeljenjeDTO> convert(List<Odeljenje> odeljenja){
        List<OdeljenjeDTO> odeljenjaDTO = new ArrayList<>();

        for(Odeljenje odeljenje : odeljenja) {
            odeljenjaDTO.add(convert(odeljenje));
        }

        return odeljenjaDTO;
    }

	
	

}

