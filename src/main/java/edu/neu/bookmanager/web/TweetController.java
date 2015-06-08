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

import edu.neu.bookmanager.domain.Tweet;
import edu.neu.bookmanager.service.TweetService;

@Controller
@RequestMapping("/tweets")
public class TweetController {
	
	@Autowired
	private TweetService tweetService;
	
	@RequestMapping(method=RequestMethod.POST)
	public String addTweet(@Valid Tweet tweet, BindingResult result) {
		if (result.hasErrors()) {
			return "tweets";
		}
			
		tweetService.addTweet(tweet);
		
		return "redirect:/tweets";
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String listTweets(Model model) {
		model.addAttribute("tweet", new Tweet());
		model.addAttribute("tweetList", tweetService.listTweets());
		
		return "tweets";
	}
	
	@RequestMapping(value="/{tweetId}", method=RequestMethod.GET)
	public String getTweet(@PathVariable Integer tweetId, Model model) {
		model.addAttribute("tweet", tweetService.getTweet(tweetId));
		
		return "tweets";
	}
	
	@RequestMapping(value="/{tweetId}/photo", method = RequestMethod.GET)
    public @ResponseBody String viewPhoto(@PathVariable Integer tweetId, HttpServletResponse response) throws IOException {
    	Tweet tweet = tweetService.getTweet(tweetId);
    	byte[] photoBytes = tweet.getCoverPhoto();
    	if (photoBytes != null) {
	    	int length = photoBytes.length;
	    	ServletOutputStream op = response.getOutputStream();
	        
	    	response.setContentType("image/jpeg");
	    	response.setContentLength(length);
	    	response.setHeader("Content-Disposition",
	    			"attachment; filename=\"photo_" + tweet.getTweetId() + ".jpg\"");
	
	    	op.write(photoBytes, 0, length);
	    	op.flush();
	    	op.close();
    	}
 
        return "";
    }
	
	@RequestMapping(value="/{tweetId}", method=RequestMethod.DELETE)
	public @ResponseBody String deleteTweet(@PathVariable Integer tweetId) {
		tweetService.removeTweet(tweetId);
		
		return "";
	}
}
