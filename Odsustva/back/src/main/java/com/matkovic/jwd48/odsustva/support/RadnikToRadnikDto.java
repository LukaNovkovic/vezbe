package com.matkovic.jwd48.odsustva.support;

import org.springframework.stereotype.Component;

import com.matkovic.jwd48.odsustva.model.Radnik;
import com.matkovic.jwd48.odsustva.model.Odsustvo;
import com.matkovic.jwd48.odsustva.service.OdsustvoService;
import com.matkovic.jwd48.odsustva.web.dto.RadnikDTO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

@Component
public class RadnikToRadnikDto implements Converter<Radnik, RadnikDTO>{

	@Autowired
	OdsustvoService odsustvoService;
	
	
	@Override
	public RadnikDTO convert(Radnik radnik) {
		// TODO Auto-generated method stub
		RadnikDTO dto = new RadnikDTO();
		
		dto.setEmail(radnik.getEmail());
		dto.setGodinaStaza(radnik.getGodinaStaza());
		dto.setId(radnik.getId());
		dto.setImePrezime(radnik.getImePrezime());
		dto.setJmbg(radnik.getJmbg());
		dto.setOdeljenjeId(radnik.getOdeljenje().getId());
		dto.setOdeljenjeIme(radnik.getOdeljenje().getIme());
		
//		List<Odsustvo> odsustva = radnik.getOdsustva();
//		int iskorisceniDani = 0;
//		for (Odsustvo odsustvo : odsustva) {
//			iskorisceniDani += odsustvo.getRadnihDana();
//		}
//		
//		dto.setSlobodnihDana(radnik.getSlobodnihDana() - iskorisceniDani);
		
		dto.setSlobodnihDana(radnik.getSlobodnihDana());
		

		
		return dto;
	}
	
	public List<RadnikDTO> convert(List<Radnik> radnici){
		
		List<RadnikDTO> radniciDTO = new ArrayList<RadnikDTO>();
		for (Radnik radnik : radnici) {
			radniciDTO.add(convert(radnik));
		}
		return radniciDTO;
	}
	

}
