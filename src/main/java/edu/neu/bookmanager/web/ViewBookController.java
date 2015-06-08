package edu.neu.bookmanager.web;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.neu.bookmanager.domain.Book;
import edu.neu.bookmanager.service.BookService;

@Controller
@RequestMapping("/viewbooks")
public class ViewBookController {
	
	@Autowired
	private BookService bookService;
	
//	@RequestMapping(method=RequestMethod.POST)
//	public String addBook(@Valid Book book, BindingResult result) {
//		if (result.hasErrors()) {
//		
//			return "books";
//		}
//			
//		bookService.addBook(book);
//		
//		return "redirect:/books";
//	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String listBooks(Model model) {
		
		model.addAttribute("bookList", bookService.listBooks());
		
		return "viewbooks";
	}
	
	@RequestMapping(value="/{bookId}", method=RequestMethod.GET)
	public String getBook(@PathVariable Integer bookId, Model model) {
		model.addAttribute("book", bookService.getBook(bookId));
		
		return "books";
	}
	
	@RequestMapping(value="/{bookId}/photo", method = RequestMethod.GET)
    public @ResponseBody String viewPhoto(@PathVariable Integer bookId, HttpServletResponse response) throws IOException {
    	Book book = bookService.getBook(bookId);
    	byte[] photoBytes = book.getCoverPhoto();
    	if (photoBytes != null) {
	    	int length = photoBytes.length;
	    	ServletOutputStream op = response.getOutputStream();
	        
	    	response.setContentType("image/jpeg");
	    	response.setContentLength(length);
	    	response.setHeader("Content-Disposition",
	    			"attachment; filename=\"photo_" + book.getId() + ".jpg\"");
	
	    	op.write(photoBytes, 0, length);
	    	op.flush();
	    	op.close();
    	}
 
        return "";
    }
	
	@RequestMapping(value="/{bookId}", method=RequestMethod.DELETE)
	public @ResponseBody String deleteBook(@PathVariable Integer bookId) {
		bookService.removeBook(bookId);
		
		return "";
	}
	
	
	
	
}
