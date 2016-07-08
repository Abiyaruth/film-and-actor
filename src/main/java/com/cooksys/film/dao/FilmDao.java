package com.cooksys.film.dao;

import java.util.List;

import com.cooksys.backend.solid.model.Film;

public interface FilmDao {
	public List<Film> indexFilmTitles();

	public List<Film> indexFilms();

	public Film getFilmById(Short filmId);	
	
}
