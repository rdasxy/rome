package com.ravipatel.statusserver.models;

// Generated Jun 20, 2014 1:52:25 PM by Hibernate Tools 4.0.0

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Home object for domain model class State.
 * @see com.ravipatel.status.hibernatemodels.State
 * @author Hibernate Tools
 */
@Repository
public class StateDao {

	private static final Log log = LogFactory.getLog(StateDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(State transientInstance) {
		log.debug("persisting State instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

//	public void remove(State persistentInstance) {
//		log.debug("removing State instance");
//		try {
//			entityManager.remove(persistentInstance);
//			log.debug("remove successful");
//		} catch (RuntimeException re) {
//			log.error("remove failed", re);
//			throw re;
//		}
//	}

	public State merge(State detachedInstance) {
		log.debug("merging State instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			State result = (State)session.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	@Transactional(readOnly=true)
	public State findById(Integer id) {
		log.debug("getting State instance with id: " + id);
		try {
			Session session = sessionFactory.getCurrentSession();
			State instance = (State)session.get(State.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	@Transactional(readOnly=true)
	public List<State> allStates(){
		Session session = sessionFactory.getCurrentSession();
		List<State> states = (List<State>)session
		.createCriteria(State.class).list();
		
		return states;
	}
}
