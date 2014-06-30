package com.ravipatel.statusserver.models;

// Generated Jun 20, 2014 1:52:25 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Home object for domain model class UserState.
 * 
 * @see com.ravipatel.status.hibernatemodels.UserState
 * @author Hibernate Tools
 */
@Repository
public class UserStateDao {

	private static final Log log = LogFactory.getLog(UserStateDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(UserState transientInstance) {
		log.debug("persisting UserState instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public UserState merge(UserState detachedInstance) {
		log.debug("merging UserState instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			UserState result = (UserState) session.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public UserState findById(Integer id) {
		log.debug("getting UserState instance with id: " + id);
		try {
			Session session = sessionFactory.getCurrentSession();
			UserState instance = (UserState) session.get(UserState.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Transactional(readOnly = true)
	public List<UserState> findAllUserStateForUserId(User user) {
		Session session = sessionFactory.getCurrentSession();
		List<UserState> userState = (List<UserState>) session
				.createCriteria(UserState.class)
				.add(Restrictions.eq("user", user))
				.setFetchMode("state", FetchMode.JOIN).list();

		return userState;

	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public UserState addUserState(User user, State state) {
		UserState userState = new UserState();
		userState.setCreateTimestamp(String.valueOf((new Date()).getTime()));
		userState.setState(state);
		userState.setUser(user);
		persist(userState);
		return userState;
	}
}
