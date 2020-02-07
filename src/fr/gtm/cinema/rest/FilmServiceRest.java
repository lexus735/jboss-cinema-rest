package fr.gtm.cinema.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import fr.gtm.cinema.dao.FilmDao;
import fr.gtm.cinema.dao.PersonneDao;
import fr.gtm.cinema.entities.Acteurs;
import fr.gtm.cinema.entities.Film;
@Path("/cinema")
public class FilmServiceRest {
	
	@EJB FilmDao dao;
	@EJB PersonneDao personnedao;
	
	@GET
	@Path("/films")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Film> getFilms(){
		return dao.findAll();
		
	}
	
	
	@GET
	@Path("/acteurs")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Acteurs> getAllActeurs(){
		return personnedao.getAllActeurs();
	}
	
	@POST
	@Path("/newacteur")
	@Consumes({MediaType.APPLICATION_JSON})
	public long save(Acteurs acteur) {
		personnedao.create(acteur);
		return acteur.getId();
	}
	@GET
	@Path("/filmrealisateur/{nom}")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Film> getFilmByRealisateur(@PathParam("nom")String nom){
		return dao.findByRealisateur(nom);
	}
	
	@POST
	@Path("/new")
	@Consumes({MediaType.APPLICATION_JSON})
	public long save(Film film) {
		dao.create(film);
		return film.getId();
	}
	
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Film update(Film film) {
		dao.update(film);
		return film;
	}
	@DELETE
	@Path("/delete/{id}")
	public String delete(@PathParam("id")long id) {
		dao.delete(id);
		return "suppression ok";
	}
}
