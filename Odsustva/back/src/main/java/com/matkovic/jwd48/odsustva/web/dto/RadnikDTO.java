package com.matkovic.jwd48.odsustva.web.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;

import com.matkovic.jwd48.odsustva.model.Odeljenje;

public class RadnikDTO {

    @Positive(message = "Id zadatka mora biti pozitivan broj.")
    private Long id;

    @NotBlank
    @Size(max = 13)
    private String jmbg;
    
    private String imePrezime;

    @Email
    private String email;

	private int godinaStaza;

	private int slobodnihDana;

	private String odeljenjeIme;
	
	private Long odeljenjeId;


   

    
    
	public RadnikDTO() {
		super();
	}






	public Long getId() {
		return id;
	}






	public void setId(Long id) {
		this.id = id;
	}






	public String getJmbg() {
		return jmbg;
	}






	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}






	public String getImePrezime() {
		return imePrezime;
	}






	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}






	public String getEmail() {
		return email;
	}






	public void setEmail(String email) {
		this.email = email;
	}






	public int getGodinaStaza() {
		return godinaStaza;
	}






	public void setGodinaStaza(int godinaStaza) {
		this.godinaStaza = godinaStaza;
	}






	public int getSlobodnihDana() {
		return slobodnihDana;
	}






	public void setSlobodnihDana(int slobodnihDana) {
		this.slobodnihDana = slobodnihDana;
	}






	public String getOdeljenjeIme() {
		return odeljenjeIme;
	}






	public void setOdeljenjeIme(String odeljenjeIme) {
		this.odeljenjeIme = odeljenjeIme;
	}






	public Long getOdeljenjeId() {
		return odeljenjeId;
	}






	public void setOdeljenjeId(Long odeljenjeId) {
		this.odeljenjeId = odeljenjeId;
	}







	
   
}
