package edu.neu.bookmanager.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.bookmanager.dao.BookDAO;
import edu.neu.bookmanager.domain.Book;
import edu.neu.bookmanager.domain.Comment;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDAO;
	
	@Override
	@Transactional
	public void addBook(Book book) {
		bookDAO.addBook(book);
	}

	@Override
	@Transactional
	public List<Book> listBooks() {
		return bookDAO.listBooks();
	}

	@Override
	@Transactional
	public Book getBook(Integer id) {
		return bookDAO.getBook(id);
	}

	@Override
	@Transactional
	public void removeBook(Integer id) {
		bookDAO.removeBook(id);
	}

	@Override
	@Transactional
	public void addCommentByBookId(Comment comment, Integer bookId) {
		bookDAO.addCommentByBookId(comment, bookId);
		
	}

	@Override
	@Transactional
	public Set<Comment> listComment(Integer bookId) {
		return bookDAO.listComment(bookId);
	}

	@Override
	@Transactional
	public void postComment(String content, Integer bookId) {
		bookDAO.postComment(content, bookId);
		
	}

	@Override
	public void removeComment(Integer commentId) {
		bookDAO.removeComment(commentId);
		
	}

	
}
