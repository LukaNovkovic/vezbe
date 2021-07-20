package com.matkovic.jwd48.odsustva.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.matkovic.jwd48.odsustva.model.Odeljenje;
import com.matkovic.jwd48.odsustva.service.OdeljenjeService;
import com.matkovic.jwd48.odsustva.support.OdeljenjeToOdeljenjeDto;
import com.matkovic.jwd48.odsustva.web.dto.OdeljenjeDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/api/odeljenja", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class OdeljenjeController {

    @Autowired
    private OdeljenjeService odeljenjeService;

    @Autowired
    private OdeljenjeToOdeljenjeDto toOdeljenjeDTO;


   


    @PreAuthorize("hasAnyRole('KORISNIK', 'ADMIN')")
    @GetMapping
    public ResponseEntity<List<OdeljenjeDTO>> getAll(){

        List<Odeljenje> odeljenja = odeljenjeService.findAll();
        


        return new ResponseEntity<>(toOdeljenjeDTO.convert(odeljenja), HttpStatus.OK);
    }
    
    

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<Void> handle() {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
