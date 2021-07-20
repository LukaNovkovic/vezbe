package com.matkovic.jwd48.odsustva.web.dto;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class OdsustvoDTO {
	
    @Positive(message = "Id mora biti pozitivan broj.")
    private Long id;
    
    private String datumPocetka;

	private int radnihDana;

	private Long radnikId;
	
	private String radnikImePrezime;

	

    // @NotEmpty(message = "Nije zadat nijedan zadatak kom pripada stanje.")


	public OdsustvoDTO() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDatumPocetka() {
		return datumPocetka;
	}


	public void setDatumPocetka(String datumPocetka) {
		this.datumPocetka = datumPocetka;
	}


	public int getRadnihDana() {
		return radnihDana;
	}


	public void setRadnihDana(int radnihDana) {
		this.radnihDana = radnihDana;
	}




	public Long getRadnikId() {
		return radnikId;
	}


	public void setRadnikId(Long radnikId) {
		this.radnikId = radnikId;
	}


	public String getRadnikImePrezime() {
		return radnikImePrezime;
	}


	public void setRadnikImePrezime(String radnikImePrezime) {
		this.radnikImePrezime = radnikImePrezime;
	}


	

	

    
}
