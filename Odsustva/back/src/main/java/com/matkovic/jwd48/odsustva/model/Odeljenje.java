package com.matkovic.jwd48.odsustva.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Odeljenje {

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    //@Column - atribut klase se mapira na kolonu tabele
	    //nullable i unique su ogranicenja na moguce vrednosti kolone
	    
		@Column(nullable = false, unique = true)
	    private String ime;

		
		@Column
		private int bonus;
		
		
	    
	    @OneToMany(mappedBy = "odeljenje", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    private List<Radnik> radnici = new ArrayList<>();


		public Odeljenje() {
			super();
		}


		public Odeljenje(Long id, String ime, int bonus, List<Radnik> radnici) {
			super();
			this.id = id;
			this.ime = ime;
			this.bonus = bonus;
			this.radnici = radnici;
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


		public List<Radnik> getRadnici() {
			return radnici;
		}


		public void setRadnici(List<Radnik> radnici) {
			this.radnici = radnici;
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
			Odeljenje other = (Odeljenje) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}


		@Override
		public String toString() {
			return "Odeljenje [id=" + id + ", ime=" + ime + ", bonus=" + bonus + ", radnici=" + radnici + "]";
		}


		
	    //Svaki entity mora imati konstruktor bez parametara
		
		
}
