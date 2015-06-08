package edu.neu.bookmanager.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.bookmanager.domain.User;

@Repository
public class UserHibernateDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		sessionFactory.getCurrentSession().flush();;;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public User getUser(Integer id) {
		return (User) sessionFactory.getCurrentSession().load(User.class, id);
	}

	@Override
	public void removeUser(Integer id) {
		User user = (User) sessionFactory.getCurrentSession().get(User.class, id);
        if (null != user) {
        	try {
        		sessionFactory.getCurrentSession().delete(user);
        		sessionFactory.getCurrentSession().flush();
        	} catch (HibernateException e) {
        		e.printStackTrace();
        	}
        }
		
	}

}
