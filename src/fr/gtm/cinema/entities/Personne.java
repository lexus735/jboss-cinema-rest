
package fr.gtm.cinema.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "personnes")
@DiscriminatorColumn(name = "type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Personne implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_personne")
	private long id;
	private String civilite;
	private String nom;
	private String prenom;
	@Column(name = "date_naissance")
	private Date dateNaissance;
	@Column(name = "date_deces")
	private Date dateDeces;
	//@OneToMany(fetch= FetchType.EAGER,mappedBy="realisateur")
	//private List<Film> filmsRealise = new ArrayList<>();
	//@ManyToMany(fetch= FetchType.EAGER,mappedBy= "acteurs")
	//private List<Film> filmsTourne = new ArrayList<>();

//
//	public List<Film> getFilmsTourne() {
//		return filmsTourne;
//	}
//
//
//
//	public void setFilmsTourne(List<Film> filmsTourne) {
//		this.filmsTourne = filmsTourne;
//	}

//	public List<Film> getFilmsRealise() {
//		return filmsRealise;
//	}
//
//	public void setFilmsRealise(List<Film> filmsRealise) {
//		this.filmsRealise = filmsRealise;
//	}

	public Personne() {
		// TODO Auto-generated constructor stub
	}

	public Personne(String civilite, String nom, String prenom, Date dateNaissance, Date dateDeces) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.dateDeces = dateDeces;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Date getDateDeces() {
		return dateDeces;
	}

	public void setDateDeces(Date dateDeces) {
		this.dateDeces = dateDeces;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateNaissance=" + dateNaissance + ", dateDeces=" + dateDeces + "]";
	}

}