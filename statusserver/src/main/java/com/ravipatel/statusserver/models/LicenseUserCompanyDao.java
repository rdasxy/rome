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

/**
 * Home object for domain model class LicenseUserCompany.
 * @see com.ravipatel.status.hibernatemodels.LicenseUserCompany
 * @author Hibernate Tools
 */
@Repository
public class LicenseUserCompanyDao {

	private static final Log log = LogFactory
			.getLog(LicenseUserCompanyDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(LicenseUserCompany transientInstance) {
		log.debug("persisting LicenseUserCompany instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

//	public void remove(LicenseUserCompany persistentInstance) {
//		log.debug("removing LicenseUserCompany instance");
//		try {
//			
//			entityManager.remove(persistentInstance);
//			log.debug("remove successful");
//		} catch (RuntimeException re) {
//			log.error("remove failed", re);
//			throw re;
//		}
//	}

	public LicenseUserCompany merge(LicenseUserCompany detachedInstance) {
		log.debug("merging LicenseUserCompany instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			LicenseUserCompany result = (LicenseUserCompany) session.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public LicenseUserCompany findById(Integer id) {
		log.debug("getting LicenseUserCompany instance with id: " + id);
		try {
			Session session = sessionFactory.getCurrentSession();
			LicenseUserCompany instance = (LicenseUserCompany)session.get(
					LicenseUserCompany.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
