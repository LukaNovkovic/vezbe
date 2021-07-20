package com.matkovic.jwd48.odsustva.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.matkovic.jwd48.odsustva.model.Radnik;
import com.matkovic.jwd48.odsustva.model.Odeljenje;
import com.matkovic.jwd48.odsustva.service.RadnikService;
import com.matkovic.jwd48.odsustva.service.OdeljenjeService;
import com.matkovic.jwd48.odsustva.web.dto.OdeljenjeDTO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class OdeljenjeDtoToOdeljenje implements Converter<OdeljenjeDTO, Odeljenje> {

	@Autowired
	OdeljenjeService odeljenjeService;
	
	@Autowired
	RadnikService radnikService;
	
	@Override
	public Odeljenje convert(OdeljenjeDTO dto) {
		
		Odeljenje odeljenje;
	    if(dto.getId() == null){
	    	odeljenje = new Odeljenje();
	    }else{
	    	odeljenje = odeljenjeService.findOne(dto.getId());
	    }
	    
	    if(odeljenje != null){
	    	odeljenje.setBonus(dto.getBonus());
	    	odeljenje.setIme(dto.getIme());
	   
            List<Radnik> radnici = radnikService.findAll(); 
            odeljenje.setRadnici(radnici);
	    }
	    return odeljenje;	
	}

	
}
