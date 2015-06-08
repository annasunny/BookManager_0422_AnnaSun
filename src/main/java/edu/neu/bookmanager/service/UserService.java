package edu.neu.bookmanager.service;

import java.util.List;

import edu.neu.bookmanager.domain.Tweet;
import edu.neu.bookmanager.domain.User;

public interface UserService {
	
	public void addUser(User user);
	public List<User> listUsers();
	public User getUser(Integer id);
	public void removeUser(Integer id);
	public List<Tweet> listTweets(Integer id);
	public List<Tweet> listTweets(String username);
	
}
