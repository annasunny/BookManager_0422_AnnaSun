package edu.neu.bookmanager;

import edu.neu.bookmanager.dao.BookDAO;
import edu.neu.bookmanager.dao.BookHibernateDAOImpl;
import edu.neu.bookmanager.domain.Book;

public class Test {
   
	
	
	public static void main(String[] args){
	         	
		BookDAO bookDAO=new BookHibernateDAOImpl();
		Book book=new Book();
		book.setQuantity(10);
		book.setAuthor("azhang");
		book.setDiscription("Hello");
		book.setTitle("meiLi");
		bookDAO.addBook(book);
		
	}
	
	
}
