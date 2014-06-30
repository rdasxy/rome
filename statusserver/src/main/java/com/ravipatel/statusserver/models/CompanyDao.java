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
 * Home object for domain model class Company.
 * @see com.ravipatel.status.hibernatemodels.Company
 * @author Hibernate Tools
 */
@Repository
public class CompanyDao {

	private static final Log log = LogFactory.getLog(CompanyDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(Company transientInstance) {
		log.debug("persisting Company instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

//	public void remove(Company persistentInstance) {
//		log.debug("removing Company instance");
//		try {
//			Session session = sessionFactory.getCurrentSession();
////			session.u(persistentInstance);
//			log.debug("remove successful");
//		} catch (RuntimeException re) {
//			log.error("remove failed", re);
//			throw re;
//		}
//	}

	public Company merge(Company detachedInstance) {
		log.debug("merging Company instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			Company result = (Company) session.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	@Transactional(readOnly=true)
	public Company findById(Integer id) {
		log.debug("getting Company instance with id: " + id);
		try {
			Session session = sessionFactory.getCurrentSession();
			Company instance = (Company)session.get(Company.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
