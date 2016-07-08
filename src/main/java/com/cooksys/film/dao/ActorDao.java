package com.cooksys.film.dao;

import java.util.List;

import com.cooksys.backend.solid.model.Actor;

public interface ActorDao {

	public List<Actor> indexActorName();

	public List<Actor> indexActors();

	public Actor getActorById(Short actorId);
	
}
