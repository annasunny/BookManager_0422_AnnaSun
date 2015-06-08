package edu.neu.bookmanager.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.bookmanager.domain.Comment;

@Repository
public class CommentHibernateDAOImpl implements CommentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addComment(Comment comment) {
		sessionFactory.getCurrentSession().save(comment);
		sessionFactory.getCurrentSession().flush();;;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> listComments() {
		return sessionFactory.getCurrentSession().createQuery("from Comment").list();
	}

	@Override
	public Comment getComment(Integer id) {
		return (Comment) sessionFactory.getCurrentSession().load(Comment.class, id);
	}

	@Override
	public void removeComment(Integer id) {
		Comment comment = (Comment) sessionFactory.getCurrentSession().get(Comment.class, id);
        if (null != comment) {
        	try {
        		sessionFactory.getCurrentSession().delete(comment);
        		sessionFactory.getCurrentSession().flush();
        	} catch (HibernateException e) {
        		e.printStackTrace();
        	}
        }
	}
}

