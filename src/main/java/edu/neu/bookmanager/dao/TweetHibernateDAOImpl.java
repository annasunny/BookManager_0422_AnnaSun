package edu.neu.bookmanager.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.bookmanager.domain.Tweet;

@Repository
public class TweetHibernateDAOImpl implements TweetDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addTweet(Tweet tweet) {
		sessionFactory.getCurrentSession().save(tweet);
		sessionFactory.getCurrentSession().flush();;;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tweet> listTweets() {
		return sessionFactory.getCurrentSession().createQuery("from Tweet").list();
	}

	@Override
	public Tweet getTweet(Integer id) {
		return (Tweet) sessionFactory.getCurrentSession().load(Tweet.class, id);
	}

	@Override
	public void removeTweet(Integer id) {
		Tweet tweet = (Tweet) sessionFactory.getCurrentSession().get(Tweet.class, id);
        if (null != tweet) {
        	try {
        		sessionFactory.getCurrentSession().delete(tweet);
        		sessionFactory.getCurrentSession().flush();
        	} catch (HibernateException e) {
        		e.printStackTrace();
        	}
        }
	}
}
