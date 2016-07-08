package com.cooksys.film;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.backend.solid.model.Actor;
import com.cooksys.backend.solid.model.Film;
import com.cooksys.film.dao.FilmDao;

@RestController
@RequestMapping("/films")
public class FilmController {
	
	@Autowired
	private FilmDao filmDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Film> index(){
		return filmDao.indexFilms();
	}
	
	@RequestMapping(value = "/{filmId}", method = RequestMethod.GET)
	public Film getFilmById(@PathVariable Short filmId) {
		return filmDao.getFilmById(filmId);
	}
}
