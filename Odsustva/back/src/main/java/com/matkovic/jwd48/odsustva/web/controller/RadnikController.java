package com.matkovic.jwd48.odsustva.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.matkovic.jwd48.odsustva.model.Radnik;
import com.matkovic.jwd48.odsustva.model.Odsustvo;
import com.matkovic.jwd48.odsustva.repository.RadnikRepository;
import com.matkovic.jwd48.odsustva.service.RadnikService;
import com.matkovic.jwd48.odsustva.service.OdsustvoService;
import com.matkovic.jwd48.odsustva.support.RadnikDtoToRadnik;
import com.matkovic.jwd48.odsustva.support.RadnikToRadnikDto;
import com.matkovic.jwd48.odsustva.web.dto.RadnikDTO;

@RestController
@RequestMapping(value = "/api/radnici", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class RadnikController {
	
	@Autowired
	RadnikService radnikService;
	
	@Autowired
	OdsustvoService odsustvoService;
	
	@Autowired
	RadnikToRadnikDto toRadnikDTO;
	
	@Autowired
	RadnikDtoToRadnik toRadnik;
	
  @PreAuthorize("hasRole('ADMIN')")
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RadnikDTO> create(@Valid @RequestBody RadnikDTO radnikDTO){
	  
      Radnik radnik = toRadnik.convert(radnikDTO);

      if(radnik.getJmbg().length() != 13 || radnik.getEmail() == null) {
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
      Radnik sacuvan = radnikService.save(radnik);

      return new ResponseEntity<>(toRadnikDTO.convert(sacuvan), HttpStatus.CREATED);
  }
  
  @PreAuthorize("hasRole('ADMIN')")
  @PutMapping(value= "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RadnikDTO> update(@PathVariable Long id, @Valid @RequestBody RadnikDTO radnikDTO){

      if(!id.equals(radnikDTO.getId())) {
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }

      Radnik radnik = toRadnik.convert(radnikDTO);

      if(radnik.getJmbg().length() != 13 || radnik.getEmail() == null) {
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }

      Radnik sacuvanZadatak = radnikService.update(radnik);

      return new ResponseEntity<>(toRadnikDTO.convert(sacuvanZadatak), HttpStatus.CREATED);
  }
  

  
  @PreAuthorize("hasRole('ADMIN')")
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id){
	  Radnik obrisana = radnikService.delete(id);

      if(obrisana != null) {
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
  }
  
  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
  @GetMapping("/{id}")
  public ResponseEntity<RadnikDTO> getOne(@PathVariable Long id){
      Radnik radnik = radnikService.findOne(id);

      if(radnik != null) {
          return new ResponseEntity<>(toRadnikDTO.convert(radnik), HttpStatus.OK);
      }else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
  }
	
  @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
  @GetMapping
  public ResponseEntity<List<RadnikDTO>> getAll(
		     	@RequestParam(required=false) Long odeljenjeId,
	            @RequestParam(required=false) String jmbg,
	            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo){

      Page<Radnik> page = radnikService.search(odeljenjeId, jmbg, pageNo);
      

      HttpHeaders headers = new HttpHeaders();
      headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

      return new ResponseEntity<>(toRadnikDTO.convert(page.getContent()), headers, HttpStatus.OK);
  }
  
  

  @ExceptionHandler(value = DataIntegrityViolationException.class)
  public ResponseEntity<Void> handle() {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
	

}
