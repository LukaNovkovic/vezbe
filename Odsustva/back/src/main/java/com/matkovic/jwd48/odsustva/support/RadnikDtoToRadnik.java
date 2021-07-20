package com.matkovic.jwd48.odsustva.support;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.matkovic.jwd48.odsustva.model.Odeljenje;
import com.matkovic.jwd48.odsustva.model.Radnik;
import com.matkovic.jwd48.odsustva.service.RadnikService;
import com.matkovic.jwd48.odsustva.service.OdeljenjeService;
import com.matkovic.jwd48.odsustva.service.OdsustvoService;
import com.matkovic.jwd48.odsustva.web.dto.RadnikDTO;

@Component
public class RadnikDtoToRadnik implements Converter<RadnikDTO, Radnik>{

	@Autowired
	RadnikService radnikService;
	
	@Autowired
	OdeljenjeService odeljenjeService;
	
	@Autowired
	OdsustvoService odsustvoService;
	
	@Override
	public Radnik convert(RadnikDTO dto) {
		// TODO Auto-generated method stub
		Radnik radnik;
	    if(dto.getId() == null){
	    	radnik = new Radnik();
	    	Odeljenje odeljenje = odeljenjeService.findOne(dto.getOdeljenjeId());
			int slobodnihDana = 20 + dto.getGodinaStaza()/5 + odeljenje.getBonus();
	    	radnik.setSlobodnihDana(slobodnihDana);
	    }else{
	        radnik = radnikService.findOne(dto.getId());
	    }

	    if(radnik != null){
	    	radnik.setEmail(dto.getEmail());
	    	radnik.setGodinaStaza(dto.getGodinaStaza());
	    	radnik.setImePrezime(dto.getImePrezime());
	    	radnik.setJmbg(dto.getJmbg());
	    	radnik.setOdeljenje(odeljenjeService.findOne(dto.getOdeljenjeId()));
	    	
	    	
	    }
	    return radnik;	
	}
	
	private LocalDateTime getLocalDateTime(String dateTime) throws DateTimeParseException {
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	     return LocalDateTime.parse(dateTime, formatter);
	}

}
