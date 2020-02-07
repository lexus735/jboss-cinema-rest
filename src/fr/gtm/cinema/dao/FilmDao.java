package fr.gtm.cinema.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Singleton;

import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.gtm.cinema.entities.Film;

@Singleton
@Interceptors(FilmDaoInterceptor.class)
public class FilmDao extends AbstractDao<Film, Long>{
	@PersistenceContext(name="cinema") private EntityManager em;
	private Logger LOG = Logger.getLogger(FilmDaoInterceptor.class.getName());
	public FilmDao() {
		super(Film.class);
		LOG.info(">>>Contructeur de"+this.getClass().getName());
	}
	
	public List<Film> findAll(){
		return em.createNamedQuery("Film.findAll", Film.class)
									.getResultList();
	}
	
	public List<Film> findByYear(int year){
		return em.createNamedQuery("Film.findByYear", Film.class)
									.setParameter("year", year)
									.getResultList();
	}
	public List<Film> findByRealisateur(String nom){
		
		 List<Film> films = em.createNamedQuery("Film.findByRealisateur", Film.class).setParameter("nom", nom).getResultList();
		return films;
	}
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}


}
