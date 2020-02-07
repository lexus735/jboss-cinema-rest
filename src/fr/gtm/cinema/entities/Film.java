package fr.gtm.cinema.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = {"resume"},includeFieldNames = false)

@Entity @Table(name="films")
@SecondaryTable(name = "resumes",pkJoinColumns = @PrimaryKeyJoinColumn(name="fk_film"))
@NamedQuery(name="Film.findAll",
			query = "SELECT f FROM Film f")
@NamedQuery(name="Film.findByYear",
			query = "SELECT f FROM Film f WHERE YEAR(f.dateSortie) = :year")
@NamedQuery(name= "Film.findByRealisateur", query = "SELECT f FROM Film f WHERE f.realisateur.nom = :nom")
public class Film implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pk_film")
	private long id;
	private String titre;
	@Column(name="prixht")
	private double prixHT;
	private int duree;
	@Column(name = "date_sortie")
	private LocalDate dateSortie;
	@Column(table = "resumes",name = "resume")
	@Transient
	private String resume;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="fk_realisateur")
	private Realisateurs realisateur;
	
	public Film() {}
	
	public Film(String titre, int duree) {
		this.titre = titre;
		this.duree = duree;
	}
	
}
