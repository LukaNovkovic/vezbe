package com.matkovic.jwd48.odsustva.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.matkovic.jwd48.odsustva.model.Radnik;

import java.util.*;

public class OdeljenjeDTO {

    @Positive(message = "Id mora biti pozitivan broj.")
    private Long id;

    private String ime;

	private int bonus;

	


    
	public OdeljenjeDTO() {
		super();
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
	}





	public String getIme() {
		return ime;
	}





	public void setIme(String ime) {
		this.ime = ime;
	}





	public int getBonus() {
		return bonus;
	}





	public void setBonus(int bonus) {
		this.bonus = bonus;
	}







    

}
