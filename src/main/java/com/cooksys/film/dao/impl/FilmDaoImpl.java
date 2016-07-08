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
import com.cooksys.backend.solid.model.Film;
import com.cooksys.film.dao.FilmDao;

@Repository
@Transactional
public class FilmDaoImpl implements FilmDao{

private Logger log = LoggerFactory.getLogger(FilmDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Film> indexFilms() {

		return sessionFactory.getCurrentSession()
		.createQuery("from Film f")
		.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Film> indexFilmTitles() {

		return sessionFactory.getCurrentSession()
		.createQuery("select f.title from Film f")
		.list();
	}
	
	@Override
	public Film getFilmById(Short filmId) {
		Session session = sessionFactory.getCurrentSession();
		Film result = session.get(Film.class, filmId);
		return result;
	}

/****************************************************************************
 * Before transaction injection happened this was needed 
 ***************************************************************************/		
//		Session session = null;
//		Transaction tx = null;
//		List<String> result = null;
//				
//		try {
//			session = sessionFactory.openSession();
//			tx = session.beginTransaction();
//			Query query = session.createQuery("select f.title from Film f");
//			result = query.list();
//		} catch (Throwable t) {
//			log.warn("Failed to index actor name", t);
//			if (tx != null) {
//				tx.rollback();
//			}
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//		
//		return result;
		
}
