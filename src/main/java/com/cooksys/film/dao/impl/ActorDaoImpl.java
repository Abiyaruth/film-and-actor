package com.cooksys.film.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cooksys.backend.solid.model.Actor;
import com.cooksys.film.dao.ActorDao;

@Repository
@Transactional
public class ActorDaoImpl implements ActorDao{

	private Logger log = LoggerFactory.getLogger(ActorDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Actor> indexActors() {
		return sessionFactory.getCurrentSession()
		.createQuery("from Actor")
		.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Actor> indexActorName() {
		return sessionFactory.getCurrentSession()
		.createQuery("select concat(a.firstName, ' ', a.lastName) from Actor a")
		.list();
	}

	@Override
	public Actor getActorById(Short actorId) {
		Session session = sessionFactory.getCurrentSession();
		Actor result = session.get(Actor.class, actorId);
		return result;
	}

}
