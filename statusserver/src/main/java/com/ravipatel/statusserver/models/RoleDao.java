package com.ravipatel.statusserver.models;

// Generated Jun 20, 2014 1:52:25 PM by Hibernate Tools 4.0.0

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
 * Home object for domain model class Role.
 * @see com.ravipatel.status.hibernatemodels.Role
 * @author Hibernate Tools
 */
@Repository
public class RoleDao {

	private static final Log log = LogFactory.getLog(RoleDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(Role transientInstance) {
		log.debug("persisting Role instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

//	public void remove(Role persistentInstance) {
//		log.debug("removing Role instance");
//		try {
//			entityManager.remove(persistentInstance);
//			log.debug("remove successful");
//		} catch (RuntimeException re) {
//			log.error("remove failed", re);
//			throw re;
//		}
//	}

	public Role merge(Role detachedInstance) {
		log.debug("merging Role instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			Role result = (Role)session.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Transactional(readOnly=true)
	public Role findById(Integer id) {
		log.debug("getting Role instance with id: " + id);
		try {
			Session session = sessionFactory.getCurrentSession();
			Role instance = (Role)session.get(Role.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
