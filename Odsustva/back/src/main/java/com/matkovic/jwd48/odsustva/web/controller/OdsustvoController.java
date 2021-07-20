package com.matkovic.jwd48.odsustva.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matkovic.jwd48.odsustva.model.Radnik;
import com.matkovic.jwd48.odsustva.model.Odsustvo;
import com.matkovic.jwd48.odsustva.service.RadnikService;
import com.matkovic.jwd48.odsustva.service.OdsustvoService;
import com.matkovic.jwd48.odsustva.support.OdsustvoDtoToOdsustvo;
import com.matkovic.jwd48.odsustva.support.OdsustvoToOdsustvoDto;
import com.matkovic.jwd48.odsustva.web.dto.RadnikDTO;
import com.matkovic.jwd48.odsustva.web.dto.OdsustvoDTO;

@RestController
@RequestMapping(value = "/api/odsustva", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class OdsustvoController {
	
	@Autowired
	OdsustvoService odsustvoService;
	
	@Autowired
	RadnikService radnikService;
	
	@Autowired
	OdsustvoToOdsustvoDto toOdsustvoDTO;

	@Autowired
	OdsustvoDtoToOdsustvo toOdsustvo;
	
//  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
	@GetMapping
	public ResponseEntity<List<OdsustvoDTO>> getAll(){

      List<Odsustvo> rezervacije = odsustvoService.findAll();
      


      return new ResponseEntity<>(toOdsustvoDTO.convert(rezervacije), HttpStatus.OK);
  }
  
//	@PreAuthorize("hasRole('KORISNIK')")
//	@PutMapping("/rezervisi/{id}")
//	public ResponseEntity<OdsustvoDTO> ticketReservation(@PathVariable Long id){
//	
//		Odsustvo odsustvo = odsustvoService.findOne(id);
//		Radnik radnik = odsustvo.getLinija();
//
//	    if(odsustvo == null || (odsustvo.getBrojRezervacija() >= radnik.getBrojMesta())) {
//	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//	    }
//	    int noviBrojRezervacija = odsustvo.getBrojRezervacija() + 1;
//	    odsustvo.setBrojRezervacija(noviBrojRezervacija);
//	    Odsustvo izmenjenaRezervacija = odsustvoService.update(odsustvo);
//	   
//	    return new ResponseEntity<>(toRezervacijaDTO.convert(izmenjenaRezervacija), HttpStatus.CREATED);
//	}
  
  
  @PreAuthorize("hasRole('KORISNIK')")
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<OdsustvoDTO> update(@Valid @RequestBody OdsustvoDTO odsustvoDTO){
      
      Radnik radnik = radnikService.findOne(odsustvoDTO.getRadnikId());

      if(radnik != null) {
    	   if(odsustvoDTO.getRadnihDana() > radnik.getSlobodnihDana()) {
    	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	      }
    	   Odsustvo odsustvo = toOdsustvo.convert(odsustvoDTO);

    	   if(odsustvo.getRadnihDana()<0 || odsustvo.getDatumPocetka() == null) {
    	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	   }
    	   Odsustvo sacuvana = odsustvoService.save(odsustvo);

    	   radnik.setSlobodnihDana(radnik.getSlobodnihDana() - sacuvana.getRadnihDana());
    	   radnikService.update(radnik);
    	   
    	   return new ResponseEntity<>(toOdsustvoDTO.convert(sacuvana), HttpStatus.CREATED);
      }
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
  

  @ExceptionHandler(value = DataIntegrityViolationException.class)
  public ResponseEntity<Void> handle() {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
}
