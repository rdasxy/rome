package com.ravipatel.statusserver.models;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRoleDao {

	private static final Log log = LogFactory.getLog(UserRoleDao.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void persist(UserRole transientInstance) {
		log.debug("persisting UserRole instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

//	public void remove(UserRole persistentInstance) {
//		log.debug("removing UserRole instance");
//		try {
//			entityManager.remove(persistentInstance);
//			log.debug("remove successful");
//		} catch (RuntimeException re) {
//			log.error("remove failed", re);
//			throw re;
//		}
//	}

	public UserRole merge(UserRole detachedInstance) {
		log.debug("merging UserRole instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			UserRole result = (UserRole)session.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserRole findById(Integer id) {
		log.debug("getting UserRole instance with id: " + id);
		try {
			Session session = sessionFactory.getCurrentSession();
			UserRole instance = (UserRole)session.get(UserRole.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public UserRole addUserToRole(User user,Role role){
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		persist(userRole);
		return userRole;
	}
}
