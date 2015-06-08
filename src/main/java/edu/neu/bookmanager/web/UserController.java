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

import edu.neu.bookmanager.domain.User;
import edu.neu.bookmanager.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.POST)
	public String addUser(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "users";
		}
			
		userService.addUser(user);
		
		return "redirect:/users";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String listUsers(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("userList", userService.listUsers());
		
		return "users";
	}
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
	public String getUser(@PathVariable Integer userId, Model model) {
		model.addAttribute("user", userService.getUser(userId));
		
		return "users";
	}
	
	@RequestMapping(value="/{userId}/photo", method = RequestMethod.GET)
    public @ResponseBody String viewPhoto(@PathVariable Integer userId, HttpServletResponse response) throws IOException {
    	User user = userService.getUser(userId);
    	byte[] photoBytes = user.getCoverPhoto();
    	if (photoBytes != null) {
	    	int length = photoBytes.length;
	    	ServletOutputStream op = response.getOutputStream();
	        
	    	response.setContentType("image/jpeg");
	    	response.setContentLength(length);
	    	response.setHeader("Content-Disposition",
	    			"attachment; filename=\"photo_" + user.getUserId() + ".jpg\"");
	
	    	op.write(photoBytes, 0, length);
	    	op.flush();
	    	op.close();
    	}
 
        return "";
    }
	
	@RequestMapping(value="/{userId}", method=RequestMethod.DELETE)
	public @ResponseBody String deleteUser(@PathVariable Integer userId) {
		userService.removeUser(userId);
		
		return "";
	}
}
