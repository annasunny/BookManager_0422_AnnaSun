package edu.neu.bookmanager.service;

import java.util.List;
import java.util.Set;

import edu.neu.bookmanager.domain.Book;
import edu.neu.bookmanager.domain.Comment;

public interface BookService {
	
	public void addBook(Book book);
	public List<Book> listBooks();
	public Book getBook(Integer id);
	public void removeBook(Integer id);
	
	public void postComment(String content,Integer bookId);
	public void addCommentByBookId(Comment comment, Integer bookId);
	public Set<Comment> listComment(Integer bookId);
	public void removeComment(Integer commentId);
	
	
}
