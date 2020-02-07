package fr.gtm.cinema.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.gtm.cinema.entities.Acteurs;
import fr.gtm.cinema.entities.Personne;
import fr.gtm.cinema.entities.Realisateurs;
@Singleton
public class PersonneDao extends AbstractDao<Personne, Long> {
	@PersistenceContext(name="cinema") private EntityManager em;
public PersonneDao() {
	super(Personne.class);
}

	public List<Realisateurs> getAllRealisateurs(){
		List<Realisateurs> realisateurs = em.createQuery("SELECT r FROM Realisateurs r",Realisateurs.class).getResultList();
		return realisateurs;
	}
	public List<Acteurs> getAllActeurs(){
		List<Acteurs> acteurs = em.createQuery("SELECT a FROM Acteurs a",Acteurs.class).getResultList();
		
		return acteurs;
}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	}