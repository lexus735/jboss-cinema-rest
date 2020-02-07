package fr.gtm.cinema.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")

public class Acteurs extends Personne {

	public Acteurs() {
		// TODO Auto-generated constructor stub
	}

	public Acteurs(String civilite, String nom, String prenom, Date dateNaissance, Date dateDeces) {
		super(civilite, nom, prenom, dateNaissance, dateDeces);
		// TODO Auto-generated constructor stub
	}
}