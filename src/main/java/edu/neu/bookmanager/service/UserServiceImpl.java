package edu.neu.bookmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.neu.bookmanager.dao.UserDAO;
import edu.neu.bookmanager.domain.Tweet;
import edu.neu.bookmanager.domain.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	@Transactional
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Override
	@Transactional
	public List<User> listUsers() {
		return userDAO.listUsers();
	}

	@Override
	@Transactional
	public User getUser(Integer id) {
		return userDAO.getUser(id);
	}

	@Override
	@Transactional
	public void removeUser(Integer id) {
		userDAO.removeUser(id);
	}

	@Override
	public List<Tweet> listTweets(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tweet> listTweets(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
