package fr.gtm.cinema.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;

import fr.gtm.cinema.dao.FilmDao;
import fr.gtm.cinema.entities.Film;

@Singleton
public class CinemaService {
	@EJB private FilmDao dao;
	
	public List<Film> findAllFilms(){
		return dao.findAll();
	}
	
	public Film findFilmById(long id) {
		return dao.findById(id);
	}
}
