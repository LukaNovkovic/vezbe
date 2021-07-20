package com.matkovic.jwd48.odsustva.support;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.matkovic.jwd48.odsustva.model.Radnik;
import com.matkovic.jwd48.odsustva.model.Odsustvo;
import com.matkovic.jwd48.odsustva.web.dto.OdsustvoDTO;

@Component
public class OdsustvoToOdsustvoDto implements Converter<Odsustvo, OdsustvoDTO>{

	@Override
	public OdsustvoDTO convert(Odsustvo odsustvo) {
		// TODO Auto-generated method stub
		OdsustvoDTO dto = new OdsustvoDTO();
		
		dto.setDatumPocetka(odsustvo.getDatumPocetka());
		dto.setId(odsustvo.getId());
		dto.setRadnihDana(odsustvo.getRadnihDana());
		dto.setRadnikId(odsustvo.getRadnik().getId());
		dto.setRadnikImePrezime(odsustvo.getRadnik().getImePrezime());
		

		return dto;
	}
	
	public List<OdsustvoDTO> convert(List<Odsustvo> odsustva) {
		
		List<OdsustvoDTO> odsustvaDTO = new ArrayList<OdsustvoDTO>();
		for (Odsustvo odsustvo : odsustva) {
			odsustvaDTO.add(convert(odsustvo));
		}
		return odsustvaDTO;
	}

}
