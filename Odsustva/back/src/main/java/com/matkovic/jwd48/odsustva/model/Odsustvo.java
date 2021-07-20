package com.matkovic.jwd48.odsustva.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;




@Entity
public class Odsustvo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	
	@Column(nullable = false)
    private String datumPocetka;
	
	@Column(nullable = false)
	private int radnihDana;
	
	@ManyToOne
	private Radnik radnik;

	
	
	public Odsustvo() {
		super();
	}



	public Odsustvo(Long id, String datumPocetka, int radnihDana, Radnik radnik) {
		super();
		this.id = id;
		this.datumPocetka = datumPocetka;
		this.radnihDana = radnihDana;
		this.radnik = radnik;
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



	public Radnik getRadnik() {
		return radnik;
	}



	public void setRadnik(Radnik radnik) {
		this.radnik = radnik;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Odsustvo other = (Odsustvo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Odsustvo [id=" + id + ", datumPocetka=" + datumPocetka + ", radnihDana=" + radnihDana + ", radnik="
				+ radnik + "]";
	}
	
	
    //@Column - atribut klase se mapira na kolonu tabele
    //nullable i unique su ogranicenja na moguce vrednosti kolone
    
	

	
	
   
	


   
}
