package com.matkovic.jwd48.odsustva.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
//@Table(name="zadaci")
public class Radnik {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(nullable = false, unique = true)
    private String jmbg;
	
	@Column(nullable = false)
    private String imePrezime;
	
	@Column
    private String email;

	@Column
	private int godinaStaza;

	@Column
	private int slobodnihDana;
	
	
	@ManyToOne
	private Odeljenje odeljenje;
	
    
    @OneToMany(mappedBy = "radnik", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Odsustvo> odsustva = new ArrayList<>();
	

	

	
	
	public Radnik() {
		super();
	}









	public List<Odsustvo> getOdsustva() {
		return odsustva;
	}









	public void setOdsustva(List<Odsustvo> odsustva) {
		this.odsustva = odsustva;
	}









	public Radnik(Long id, String jmbg, String imePrezime, String email, int godinaStaza, int slobodnihDana,
			Odeljenje odeljenje, List<Odsustvo> odsustva) {
		super();
		this.id = id;
		this.jmbg = jmbg;
		this.imePrezime = imePrezime;
		this.email = email;
		this.godinaStaza = godinaStaza;
		this.slobodnihDana = slobodnihDana;
		this.odeljenje = odeljenje;
		this.odsustva = odsustva;
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

//	public void setSlobodnihDana(int slobodnihDana) {
//		this.slobodnihDana = 20 + this.godinaStaza/5 + this.odeljenje.getBonus();
//	}

	public void setSlobodnihDana(int slobodnihDana) {
	this.slobodnihDana = slobodnihDana;
}

	public Odeljenje getOdeljenje() {
		return odeljenje;
	}



	public void setOdeljenje(Odeljenje odeljenje) {
		this.odeljenje = odeljenje;
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
		Radnik other = (Radnik) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Radnik [id=" + id + ", jmbg=" + jmbg + ", imePrezime=" + imePrezime + ", email=" + email
				+ ", godinaStaza=" + godinaStaza + ", slobodnihDana=" + slobodnihDana + ", odeljenje=" + odeljenje
				+ "]";
	}


	
}
