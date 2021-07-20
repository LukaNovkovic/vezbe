package com.matkovic.jwd48.odsustva.support;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.matkovic.jwd48.odsustva.model.Radnik;
import com.matkovic.jwd48.odsustva.model.Odeljenje;
import com.matkovic.jwd48.odsustva.model.Odsustvo;
import com.matkovic.jwd48.odsustva.service.RadnikService;
import com.matkovic.jwd48.odsustva.service.OdeljenjeService;
import com.matkovic.jwd48.odsustva.service.OdsustvoService;
import com.matkovic.jwd48.odsustva.web.dto.OdeljenjeDTO;
import com.matkovic.jwd48.odsustva.web.dto.OdsustvoDTO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class OdsustvoDtoToOdsustvo implements Converter<OdsustvoDTO, Odsustvo>{

	@Autowired
	OdsustvoService odsustvoService;
	
	@Autowired
	RadnikService radnikService;
	
	@Override
	public Odsustvo convert(OdsustvoDTO dto) {
		Odsustvo odsustvo;
	    if(dto.getId() == null){
	    	odsustvo = new Odsustvo();
	    }else{
	    	odsustvo = odsustvoService.findOne(dto.getId());
	    }
	    
	    if(odsustvo != null){
	    	odsustvo.setDatumPocetka(dto.getDatumPocetka());
	    	odsustvo.setRadnihDana(dto.getRadnihDana());
	    	odsustvo.setRadnik(radnikService.findOne(dto.getRadnikId()));
	      
	    }
	    return odsustvo;	
	}

}
