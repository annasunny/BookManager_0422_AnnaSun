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
import edu.neu.bookmanager.domain.Comment;
import edu.neu.bookmanager.service.BookService;

@Controller
@RequestMapping("/comments")
public class CommentController {
	
	
	@Autowired
	private BookService bookService;

	@RequestMapping(value="/{bookId}",method=RequestMethod.POST)
	public String addComment(@Valid Comment comment, BindingResult result) {
		if (result.hasErrors()) {	
			return "comment";
		}
		System.out.println("THE BOOK_ID IS: "+comment.getBookId());
		bookService.addCommentByBookId(comment,comment.getBookId());
		
		return "redirect:"+ comment.getBookId();
	}
	
	
	@RequestMapping(value="/{bookId}", method=RequestMethod.GET)
	public String displayBook(@PathVariable Integer bookId, Model model){
		model.addAttribute("book", bookService.getBook(bookId));
		model.addAttribute("comment", new Comment());
		
		model.addAttribute("commentList", bookService.listComment(bookId));
		
		return "comment";
	}


	
//	
//	@RequestMapping(method=RequestMethod.GET)
//	public String listComments(Model model) {
//		model.addAttribute("comment", new Comment());
//		model.addAttribute("commentList", bookService.listComments());
//		
//		return "comments";
//	}
//	
//	@RequestMapping(value="/{commentId}", method=RequestMethod.GET)
//	public String getComment(@PathVariable Integer commentId, Model model) {
//		model.addAttribute("comment", bookService.getComment(commentId));
//		
//		return "comments";
//	}
//	
//	
//	
	@RequestMapping(value="/{commentId}", method=RequestMethod.DELETE)
	public @ResponseBody String deleteComment(@PathVariable Integer commentId) {
		bookService.removeComment(commentId);
		
		return "";
	}
//	
	
	
	
}
