
package edu.neu.bookmanager.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	
	
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String dd(HttpServletRequest request){
		//HttpSession session = request.getSession();
		
		return "index";
	}
}
