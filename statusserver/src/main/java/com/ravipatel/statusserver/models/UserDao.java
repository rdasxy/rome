package com.ravipatel.statusserver.models;

// Generated Jun 20, 2014 1:52:25 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ravipatel.statusserver.utils.PasswordUtil;

/**
 * Home object for domain model class User.
 * 
 * @see com.ravipatel.status.hibernatemodels.User
 * @author Hibernate Tools
 */
@Repository
public class UserDao {

	private static final Log log = LogFactory.getLog(UserDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(User transientInstance) {
		log.debug("persisting User instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	// public void remove(User persistentInstance) {
	// log.debug("removing User instance");
	// try {
	// entityManager.remove(persistentInstance);
	// log.debug("remove successful");
	// } catch (RuntimeException re) {
	// log.error("remove failed", re);
	// throw re;
	// }
	// }

	@Transactional(propagation = Propagation.REQUIRED)
	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			User result = (User) session.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	@Transactional(readOnly = true)
	public User findById(Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			Session session = sessionFactory.getCurrentSession();
			User instance = (User) session.get(User.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Transactional(readOnly = true)
	public List<User> findAll() {
		Session session = sessionFactory.getCurrentSession();
		List<User> users = (List<User>) session.createCriteria(User.class)
				.list();
		return users;
	}

	@Transactional(readOnly = true)
	public User login(String email, String password) {

		Session session = sessionFactory.getCurrentSession();
		List<User> users = (List<User>) session.createCriteria(User.class)
				.add(Restrictions.eq("email", email)).setMaxResults(1).list();
		if (users.size() > 0) {
			String inputPasswordHashed = PasswordUtil.convertToSha1(password);
			if (users.get(0).getPassword().equals(inputPasswordHashed)) {
				return users.get(0);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public User createNewUser(Company company, String email, String password,
			String firstName, String lastName) {
		User user = new User();
		user.setCompany(company);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(PasswordUtil.convertToSha1(password));
		user.setLastLoginDate(String.valueOf((new Date()).getTime()));
		persist(user);
		return user;
	}
}
