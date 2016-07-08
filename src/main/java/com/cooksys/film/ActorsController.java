package com.cooksys.film;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.backend.solid.model.Actor;
import com.cooksys.film.dao.ActorDao;

@RestController
@RequestMapping("/actors")
public class ActorsController {
	
	@Autowired
	private ActorDao actorDao;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Actor> index(){
		return actorDao.indexActors();
	}

	@RequestMapping(value = "/{actorId}", method = RequestMethod.GET)
	public Actor getActorById(@PathVariable Short actorId) {
		return actorDao.getActorById(actorId);
	}
}
