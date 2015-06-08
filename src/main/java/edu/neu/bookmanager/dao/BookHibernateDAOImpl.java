package edu.neu.bookmanager.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.neu.bookmanager.domain.Book;
import edu.neu.bookmanager.domain.Comment;

@Repository
public class BookHibernateDAOImpl implements BookDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addBook(Book book) {
		sessionFactory.getCurrentSession().save(book);
		sessionFactory.getCurrentSession().flush();
		
//		Session session = sessionFactory.openSession();
//		Transaction transaction = session.beginTransaction();
//		session.save(book);
//		transaction.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> listBooks() {
		return sessionFactory.getCurrentSession().createQuery("from Book").list();
		
	}

	@Override
	public Book getBook(Integer id) {
		return (Book) sessionFactory.getCurrentSession().load(Book.class, id);
	}

	@Override
	public void removeBook(Integer id) {
		Book book = (Book) sessionFactory.getCurrentSession().get(Book.class, id);
        if (null != book) {
        	try {
        		sessionFactory.getCurrentSession().delete(book);
        		sessionFactory.getCurrentSession().flush();
        	} catch (HibernateException e) {
        		e.printStackTrace();
        	}
        }
	}

	@Override
	public Set<Comment> listComment(Integer bookId) {
		Session session = sessionFactory.getCurrentSession();
		Book book = (Book) session.get(Book.class, bookId);
		Set<Comment> commentSet = book.getComments();
		session.merge(book);
		//session.close();
		return commentSet;
	}

	@Override
	public void addCommentByBookId(Comment comment, Integer bookId) {
		
		Session session = sessionFactory.getCurrentSession();
		Book book = (Book) session.get(Book.class, bookId);
		
		//test
		// comment.setCommentId(1);
		System.out.println("esafa");
//		comment.setBook(book);
		book.getComments().add(comment);
		session.saveOrUpdate(book);
		//session.save(book);
		session.flush();
		//session.merge(book);
		//session.close();	
	}

	@Override
	public void postComment(String content,Integer bookId) {
		Session session = sessionFactory.getCurrentSession();
		Book book = (Book) session.get(Book.class, bookId);	
		Comment comment = new Comment(content);
		book.addComment(comment);
		session.update(book);
		session.flush();
		//session.close();
		
		
	}

	@Override
	public void removeComment(Integer commentId) {
		Comment comment = (Comment) sessionFactory.getCurrentSession().get(Comment.class, commentId);
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
