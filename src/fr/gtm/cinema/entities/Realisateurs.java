package fr.gtm.cinema.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("R")

public class Realisateurs extends Personne {

	public Realisateurs() {
		// TODO Auto-generated constructor stub
		
	}

	public Realisateurs(String civilite, String nom, String prenom, Date dateNaissance, Date dateDeces) {
		super(civilite, nom, prenom, dateNaissance, dateDeces);
		// TODO Auto-generated constructor stub
	}

}